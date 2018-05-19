package com.tsystems.javaschool.brajnikov.internetstore.dao.implemenations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractGenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.OrdersDao;
import com.tsystems.javaschool.brajnikov.internetstore.exception.OrdersNotFoundException;
import com.tsystems.javaschool.brajnikov.internetstore.model.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository("orderDao")
public class OrdersDaoImpl extends AbstractGenericDao<OrderEntity, Integer> implements OrdersDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void createOrder() {
//TODO ???
    }

    public void addGoodsToOrder(GoodsEntity goodsEntity, Integer num) {
        CartItemEntity cartEntity = new CartItemEntity(); // TODO

//TODO
    }

    @SuppressWarnings("unchecked")
    public List<OrderEntity> getOrdersByUser(UserEntity userEntity) throws OrdersNotFoundException {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("from OrderEntity where user = :userParam");
        query.setParameter("userParam", userEntity);
        List<OrderEntity> ordersList = (List<OrderEntity>)query.getResultList();

//        List<OrderEntity> orders = new ArrayList<OrderEntity>();
//        OrderEntity order = new OrderEntity();
//        order.setId(1);
//        order.setSum(100);
//        order.setUser(userEntity);
//        order.setOrder_date(new Date());

//        orders.add(order); //TODO тут затычка
        return ordersList;

    }
}

