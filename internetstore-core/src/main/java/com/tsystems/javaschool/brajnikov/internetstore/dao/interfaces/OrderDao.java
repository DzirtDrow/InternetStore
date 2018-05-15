package com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dao.GenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.OrderEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;

import java.util.List;

public interface OrderDao extends GenericDao<OrderEntity, Integer> {
    void createOrder();
    void addGoodsToOrder(GoodsEntity goodsEntity, Integer num);
    List<OrderEntity> getOrdersByUser(UserEntity userEntity);
}
