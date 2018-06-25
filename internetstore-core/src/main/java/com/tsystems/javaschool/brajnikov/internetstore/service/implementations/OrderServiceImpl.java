package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.*;
import com.tsystems.javaschool.brajnikov.internetstore.dto.SessionCart;
import com.tsystems.javaschool.brajnikov.internetstore.enums.*;
import com.tsystems.javaschool.brajnikov.internetstore.exception.CartIsEmptyException;
import com.tsystems.javaschool.brajnikov.internetstore.exception.NoGoodsInStockException;
import com.tsystems.javaschool.brajnikov.internetstore.exception.OrdersNotFoundException;
import com.tsystems.javaschool.brajnikov.internetstore.model.*;
import com.tsystems.javaschool.brajnikov.internetstore.service.EmailMessageService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.persistence.NoResultException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrdersDao orderDao;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private CartDao cartDao;
    @Autowired
    private CartItemDao cartItemDao;
    @Autowired
    private EmailMessageService emailMessageService;

    static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    public void createOrder(OrderEntity orderEntity) {
        orderDao.create(orderEntity);
    }

    public int createOrderByCart(CartEntity cartEntity) throws CartIsEmptyException, NoGoodsInStockException {

        List<CartItemEntity> itemsList = cartEntity.getCartItems();

        if (itemsList.isEmpty()) {
            throw new CartIsEmptyException();
        }
        OrderEntity order = new OrderEntity();
        order.setUser(cartEntity.getUser());
        order.setStatus(OrderStatusEnum.PENDING_PAYMENT);
        order.setDeliveryType(OrderDeliveryTypeEnum.PICKUP);
        order.setPaymentMethod(OrderPaymentMethodEnum.CASH);
        order.setSumm(cartEntity.getSum());
        order.setOrder_date(new Date());

        orderDao.create(order);

        for (CartItemEntity item : itemsList) {
            item.setCart(null);
            item.setType(CartItemTypeEnum.type_order);
            item.setOrder(order);

            GoodsEntity goods = goodsDao.read(item.getGoods().getId());

            if (goods.getLeftCount() - item.getCount() > 0) {

                goods.setLeftCount(goods.getLeftCount() - item.getCount());
//                goods.setSalesCount(goods.getSalesCount() + item.getCount());

                goodsDao.update(goods);
                cartItemDao.update(item);
            } else {
                throw new NoGoodsInStockException("Goods " + "'" + goods.getId() + " : " + goods.getName() + "' have not items in stock;");
            }
        }
        order.setOrderItems(itemsList);

        try {
            String emailMessage = createMessageFromOrder(order);
            emailMessage += "<br/> Your order created!";

            String emailSubject = "You make odrer number: < " + order.getId() + " > in our Internet Store!";

            emailMessageService.sendEmail(order.getUser().getEmail(),
                    emailSubject,
                    "",
                    emailMessage
            );
        } catch (MessagingException e) {
            logger.error("Exception in OrderServiceImpl in method createOrderByCart {}", e);
        } catch (UnsupportedEncodingException e) {
            logger.error("Exception in OrderServiceImpl in method createOrderByCart {}", e);
        }
        order.setOrderItems(null);
        orderDao.create(order);

        return order.getId();
    }

    public OrderEntity getOrderById(Integer id) {
        return orderDao.read(id);
    }

    public List<OrderEntity> getAllOrders() {
        List<OrderEntity> orders;
        try {
            orders = orderDao.getOrdersList();
            return orders;
        } catch (NoResultException ex) {
            return new ArrayList<OrderEntity>();
        }
    }

    public List<OrderEntity> getOrdersListByUser(UserEntity user) throws OrdersNotFoundException {
        return orderDao.getOrdersByUser(user);
    }


    public void updateOrder(OrderEntity orderEntity) {
        orderDao.update(orderEntity);
    }

    public void pushOrderStatus(OrderEntity orderEntity) {
        OrderStatusEnum status = orderEntity.getStatus();
        if (status == OrderStatusEnum.PROCESSING) {
            status = OrderStatusEnum.PENDING_PAYMENT;

        } else if (status == OrderStatusEnum.PENDING_PAYMENT) {
            userDao.updateSpentCount(orderEntity.getUser(), orderEntity.getSumm());

            for (CartItemEntity cartItem:orderEntity.getOrderItems()) {
                GoodsEntity goods = cartItem.getGoods();
                goods.setSalesCount(goods.getSalesCount() + cartItem.getCount());
                goodsDao.update(goods);

            }
            status = OrderStatusEnum.PENDING_SHIPPING;

        } else if (status == OrderStatusEnum.PENDING_SHIPPING) {
            status = OrderStatusEnum.SHIPPED;
            if (orderEntity.getDeliveryType() == OrderDeliveryTypeEnum.PICKUP) {
                try {
                    String emailMessage = createMessageFromOrder(orderEntity);
                    emailMessage += "<br/> You can get your order in the point of delivery";
                    String emailSubject = "Your odrer number: < " + orderEntity.getId() + " > shipped to the point of delivery! Internet Store.";

                    emailMessageService.sendEmail(orderEntity.getUser().getEmail(),
                            emailSubject,
                            "",
                            emailMessage
                    );
                } catch (MessagingException e) {
                    logger.error("Exception in OrderServiceImpl in method pushOrderStatus {}", e);
                } catch (UnsupportedEncodingException e) {
                    logger.error("Exception in OrderServiceImpl in method pushOrderStatus {}", e);
                }
            }

        } else if (status == OrderStatusEnum.SHIPPED) {
            status = OrderStatusEnum.DELIVERED;

        }
        orderEntity.setStatus(status);
        orderDao.update(orderEntity);
    }

    private String createMessageFromOrder(OrderEntity orderEntity) {
        String emailMessage = "Order: <br> <table border=\"1\" cellpadding=\"1\" cellspacing=\"1\">" +
                "<thead>" +
                "<th> Item name </th>" +
                "<th> Price </th>" +
                "<th> Count </th>" +
                "<th> Total Price </th>" +
                "</thead>";
        for (CartItemEntity item : orderEntity.getOrderItems()) {
            emailMessage += "<tr>";
            emailMessage += "<td> " + item.getGoods().getName() + " </td>";
            emailMessage += "<td type=\"number\"> $" + item.getGoods().getPrice() + " </td>";
            emailMessage += "<td> " + item.getCount() + " </td>";
            emailMessage += "<td> $" + item.getGoods().getPrice() * item.getCount() + " </td>";
            emailMessage += "</tr>";

        }
        emailMessage += "</table>";


        emailMessage += "Total Order Price: $" + orderEntity.getSumm();

        return emailMessage;
    }

    @Override
    public List<OrderEntity> getAllOrdersOrderByDate(SortingTypeEnum type) {
        return orderDao.getAllOrdersOrderByDate(type);
    }

    @Override
    public List<OrderEntity> getAllOrdersOrderByStatus(SortingTypeEnum type) {
        return orderDao.getAllOrdersOrderByStatus(type);
    }

    @Override
    public void createOrderFromSessionCart(UserEntity user, SessionCart sessionCart) {

        List<CartItemEntity> itemsList = sessionCart.getCartItemsList();

        OrderEntity order = new OrderEntity();
        order.setUser(user);
        order.setStatus(OrderStatusEnum.PENDING_PAYMENT);
        order.setDeliveryType(OrderDeliveryTypeEnum.PICKUP);
        order.setPaymentMethod(OrderPaymentMethodEnum.CASH);
        order.setSumm(sessionCart.getCartTotalPrice());
        order.setOrder_date(new Date());

        orderDao.create(order);

        for (CartItemEntity item : itemsList) {

            GoodsEntity goods = goodsDao.read(item.getGoods().getId());

            item.setType(CartItemTypeEnum.type_order);
            item.setOrder(order);
            cartItemDao.create(item);

            if (goods.getLeftCount() - item.getCount() > 0) {
                goods.setLeftCount(goods.getLeftCount() - item.getCount());
                goodsDao.update(goods);

            }
        }
        sessionCart.clear();
    }

    @Override
    public Integer getWeekProceed() {
        return orderDao.getWeekProceed();
    }

    @Override
    public Integer getMonthProceed() {
        return orderDao.getMonthProceed();
    }

    @Override
    public Integer reorderById(Integer orderId) {
        OrderEntity oldOrder = orderDao.read(orderId);
        List<CartItemEntity> oldOrderItems = oldOrder.getOrderItems();
        List<CartItemEntity> newOrderItems = new ArrayList<>();

        OrderEntity newOrder = new OrderEntity();
        newOrder.setDeliveryType(OrderDeliveryTypeEnum.PICKUP);
        newOrder.setStatus(OrderStatusEnum.PENDING_PAYMENT);
        newOrder.setPaymentMethod(OrderPaymentMethodEnum.CASH);
        newOrder.setUser(oldOrder.getUser());
        newOrder.setOrder_date(new Date());
        Integer newOrderID = orderDao.create(newOrder);

        Integer summ = 0;
        for (CartItemEntity item : oldOrderItems) {
            CartItemEntity newItem = item;
            newItem.setOrder(newOrder);
            cartItemDao.create(newItem);
            summ += item.getGoods().getPrice() * item.getCount();
            newOrderItems.add(newItem);
        }


        newOrder.setOrderItems(newOrderItems);
        newOrder.setSumm(summ);

        orderDao.update(newOrder);

        return newOrderID;
    }


}
