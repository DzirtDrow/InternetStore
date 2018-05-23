package com.tsystems.javaschool.brajnikov.internetstore.dao.implemenations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractGenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.OrdersDao;
import com.tsystems.javaschool.brajnikov.internetstore.exception.OrdersNotFoundException;
import com.tsystems.javaschool.brajnikov.internetstore.model.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

import java.util.List;

@Repository("orderDao")
public class OrdersDaoImpl extends AbstractGenericDao<OrderEntity, Integer> implements OrdersDao {
    @Autowired
    private SessionFactory sessionFactory;


    @SuppressWarnings("unchecked")
    public List<OrderEntity> getOrdersByUser(UserEntity userEntity) throws OrdersNotFoundException {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("from OrderEntity where user = :userParam order by order_date desc ");
        query.setParameter("userParam", userEntity);
        List<OrderEntity> ordersList = (List<OrderEntity>)query.getResultList();

        return ordersList;

    }

    public List<OrderEntity> getOrdersList() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from OrderEntity");
        List<OrderEntity> ordersList = (List<OrderEntity>)query.getResultList();
        return ordersList;
    }
}

