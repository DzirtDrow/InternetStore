package com.tsystems.javaschool.brajnikov.internetstore.dao.implemenations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractGenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.CartDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.*;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository("cartDao")
public class CartDaoImpl extends AbstractGenericDao<CartEntity,Integer> implements CartDao{
    @Autowired
    private SessionFactory sessionFactory;

    static final Logger logger = LoggerFactory.getLogger(CartDaoImpl.class);

    public CartEntity findCartByUser(UserEntity userEntity) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from CartEntity where user = :userParam");
        query.setParameter("userParam", userEntity);
        return (CartEntity)query.getSingleResult();
    }

    public CartItemEntity getCartItemFromCartByGoods(CartEntity cartEntity, GoodsEntity goodsEntity) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("from CartItemEntity where goods = :goodsParam AND cart = :cartParam");
        query.setParameter("goodsParam", goodsEntity);
        query.setParameter("cartParam", cartEntity);
        CartItemEntity cartItemEntity;
        try {
            cartItemEntity = (CartItemEntity) query.getSingleResult();
        } catch (NoResultException ex){
            return null;
        }

        return cartItemEntity;
    }

}
