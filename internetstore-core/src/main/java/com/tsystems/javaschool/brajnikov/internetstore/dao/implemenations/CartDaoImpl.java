package com.tsystems.javaschool.brajnikov.internetstore.dao.implemenations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractGenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.CartDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository("cartDao")
public class CartDaoImpl extends AbstractGenericDao<CartEntity,Integer> implements CartDao{
    @Autowired
    private SessionFactory sessionFactory;

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

//    public int getCartTotalPrice(CartEntity cartEntity) {
//        int result = 0;
//        List<CartItemEntity> items = cartEntity.getCartItems();
//        for (CartItemEntity item: items) {
//            result += item.getGoods().getPrice() * item.getCount();
//        }
//        return result;
//    }
}
