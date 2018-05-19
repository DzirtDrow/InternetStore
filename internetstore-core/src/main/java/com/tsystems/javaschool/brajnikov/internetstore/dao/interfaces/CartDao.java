package com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dao.GenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.*;

public interface CartDao extends GenericDao<CartEntity, Integer> {
    CartEntity findCartByUser(UserEntity userEntity);

    CartItemEntity getCartItemFromCartByGoods(CartEntity cartEntity, GoodsEntity goodsEntity);

    //int getCartTotalPrice(CartEntity cartEntity);
}
