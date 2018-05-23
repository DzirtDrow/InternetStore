package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.*;
import com.tsystems.javaschool.brajnikov.internetstore.exception.CartIsEmptyException;
import com.tsystems.javaschool.brajnikov.internetstore.exception.OrdersNotFoundException;
import com.tsystems.javaschool.brajnikov.internetstore.model.*;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.OrderService;
import com.tsystems.javaschool.brajnikov.internetstore.util.CartItemTypeEnum;
import com.tsystems.javaschool.brajnikov.internetstore.util.OrderStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
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

    public void createOrder(OrderEntity orderEntity) {
        orderDao.create(orderEntity);
    }

    public int createOrderByCart(CartEntity cartEntity) throws CartIsEmptyException {

        List<CartItemEntity> itemsList = cartEntity.getCartItems();

        if(itemsList.isEmpty()){
            throw new CartIsEmptyException();
        }
        OrderEntity order = new OrderEntity();
        order.setUser(cartEntity.getUser());
        order.setStatus(OrderStatusEnum.PENDING_PAYMENT);
        order.setSum(cartEntity.getSum());
        order.setOrder_date(new Date()); // TODO date?

        orderDao.create(order);

        for (CartItemEntity item : itemsList) {

            item.setCart(null);
            item.setType(CartItemTypeEnum.type_order);
            item.setOrder(order);

            cartItemDao.update(item);
        }
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
        if(status == OrderStatusEnum.PROCESSING){
            status = OrderStatusEnum.PENDING_PAYMENT;

        } else if(status == OrderStatusEnum.PENDING_PAYMENT){
            status = OrderStatusEnum.PENDING_SHIPPING;

        }  else if(status == OrderStatusEnum.PENDING_SHIPPING){
            status = OrderStatusEnum.SHIPPED;

        }  else if(status == OrderStatusEnum.SHIPPED){
            status = OrderStatusEnum.DELIVERED;

        }
        orderEntity.setStatus(status);
        orderDao.update(orderEntity);
    }
}
