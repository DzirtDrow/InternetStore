package com.tsystems.javaschool.brajnikov.internetstore.service.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.exception.OrdersNotFoundException;
import com.tsystems.javaschool.brajnikov.internetstore.model.*;

import java.util.List;

public interface OrderService {
    void createOrder(OrderEntity orderEntity);

    int createOrderByCart(CartEntity cartEntity);


    List<OrderEntity> getAllOrders();
    List<OrderEntity> getOrdersListByUser(UserEntity user) throws OrdersNotFoundException;

    void addGoodsToOrder(GoodsEntity goodsEntity);
    List<CartItemEntity> getCarts();
}
