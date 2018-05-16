package com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dao.GenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartItemEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;

import java.util.List;

public interface CartDao extends GenericDao<CartEntity, Integer> {
    CartEntity findCartByUser(UserEntity userEntity);

    CartItemEntity getCartItemFromCartByGoods(CartEntity cartEntity, GoodsEntity goodsEntity);

}
