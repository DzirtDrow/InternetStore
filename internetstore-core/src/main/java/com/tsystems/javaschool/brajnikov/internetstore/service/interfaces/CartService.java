package com.tsystems.javaschool.brajnikov.internetstore.service.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dto.SessionCart;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartItemEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;

import java.util.List;

public interface CartService {
    void addGoodsToCart(int userId, GoodsEntity goodsEntity);

    List<CartItemEntity> getCartItems(int userId);

    void deleteCartItem(int itemId);

    void increaseItemsCount(int itemId);
    void decreaseItemsCount(int itemId);

    void loadSessionCart(int id);

    int getCartTotalPrice(int userId) ;

    CartEntity getCartByUser(UserEntity user);
}
