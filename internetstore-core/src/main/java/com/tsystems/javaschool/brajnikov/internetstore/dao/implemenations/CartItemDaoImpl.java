package com.tsystems.javaschool.brajnikov.internetstore.dao.implemenations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractGenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.CartItemDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartItemEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cartItemDao")
public class CartItemDaoImpl extends AbstractGenericDao<CartItemEntity, Integer> implements CartItemDao {
    @Autowired
    private SessionFactory sessionFactory;

}
