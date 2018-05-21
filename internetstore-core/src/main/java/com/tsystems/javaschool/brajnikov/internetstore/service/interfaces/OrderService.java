package com.tsystems.javaschool.brajnikov.internetstore.service.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.exception.CartIsEmptyException;
import com.tsystems.javaschool.brajnikov.internetstore.exception.OrdersNotFoundException;
import com.tsystems.javaschool.brajnikov.internetstore.model.*;

import java.util.List;

public interface OrderService {
    void createOrder(OrderEntity orderEntity);

    int createOrderByCart(CartEntity cartEntity) throws CartIsEmptyException;

    OrderEntity getOrderById(Integer id);

    List<OrderEntity> getAllOrders();
    List<OrderEntity> getOrdersListByUser(UserEntity user) throws OrdersNotFoundException;

    List<CartItemEntity> getCarts();

    void updateOrder(OrderEntity orderEntity);

    void pushOrderStatus(OrderEntity orderEntity);
}
