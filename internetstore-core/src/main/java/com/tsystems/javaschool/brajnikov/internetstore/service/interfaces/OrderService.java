package com.tsystems.javaschool.brajnikov.internetstore.service.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.model.CartEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartItemEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.OrderEntity;

import java.util.List;

public interface OrderService {
    void createOrder(OrderEntity orderEntity);

    int createOrderByCart(CartEntity cartEntity);


    void addGoodsToOrder(GoodsEntity goodsEntity);
    List<CartItemEntity> getCarts();
}
