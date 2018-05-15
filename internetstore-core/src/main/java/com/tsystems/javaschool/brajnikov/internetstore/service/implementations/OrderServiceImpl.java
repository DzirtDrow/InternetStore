package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.GoodsDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.OrderDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartItemEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.OrderEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private GoodsDao goodsDao;

    public void createOrder(OrderEntity orderEntity) {
        orderDao.create(orderEntity);
    }

    public void addGoodsToOrder(GoodsEntity goodsEntity) {

    }

    public List<CartItemEntity> getCarts() {
        return null;
    }
}
