package com.tsystems.javaschool.brajnikov.internetstore.dao.implemenations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractGenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.OrderDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.OrderEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("orderDao")
public class OrderDaoImpl extends AbstractGenericDao<OrderEntity, Integer> implements OrderDao{
    @Autowired
    private SessionFactory sessionFactory;
}

