package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.GoodsDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.OrdersDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.UserDao;
import com.tsystems.javaschool.brajnikov.internetstore.exception.OrdersNotFoundException;
import com.tsystems.javaschool.brajnikov.internetstore.model.*;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.OrderService;
import com.tsystems.javaschool.brajnikov.internetstore.util.CartItemTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.ArrayList;
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

    public void createOrder(OrderEntity orderEntity) {
        orderDao.create(orderEntity);
    }

    public int createOrderByCart(CartEntity cartEntity) {
        List<CartItemEntity> itemsList = cartEntity.getCartItems();
        for (CartItemEntity item : itemsList) {
            item.setCart(null);
            item.setType(CartItemTypeEnum.type_order);
        }
        OrderEntity order = new OrderEntity();
        order.setSum(cartEntity.getSum());
        orderDao.create(order);

        return order.getId();
    }

    public List<OrderEntity> getAllOrders() {
        List<OrderEntity> orders;
        try {
            orders = orderDao.getList();
            return orders;
        } catch (NoResultException ex) {
            return new ArrayList<OrderEntity>();
        }
    }

    public List<OrderEntity> getOrdersListByUser(UserEntity user) throws OrdersNotFoundException {
        return orderDao.getOrdersByUser(user);
    }

    public void addGoodsToOrder(GoodsEntity goodsEntity) {

    }

    public List<CartItemEntity> getCarts() {
        return null;
    }
}
