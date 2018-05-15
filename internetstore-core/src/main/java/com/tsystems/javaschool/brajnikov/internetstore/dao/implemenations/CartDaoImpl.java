package com.tsystems.javaschool.brajnikov.internetstore.dao.implemenations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractGenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.CartDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartItemEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cartDao")
public class CartDaoImpl extends AbstractGenericDao<CartItemEntity,Integer> implements CartDao{
    @Autowired
    private SessionFactory sessionFactory;

    public CartEntity findCartsByUserId() {
        return null;
    }
}
