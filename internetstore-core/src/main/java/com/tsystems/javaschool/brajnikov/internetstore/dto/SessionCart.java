package com.tsystems.javaschool.brajnikov.internetstore.dto;

import com.tsystems.javaschool.brajnikov.internetstore.model.CartItemEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Session cart - need to support cart in session scope
 */
@Component("sessionCart")
//@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
public class SessionCart {


    private int cartTotalPrice;

    public int getCartTotalPrice() {
        cartTotalPrice = 0;
        for (CartItemEntity item : goodsInCart.values()) {
            cartTotalPrice += item.getCount() * item.getGoods().getPrice();
        }
        return cartTotalPrice;
    }

    private Map<Integer, CartItemEntity> goodsInCart = new HashMap<Integer, CartItemEntity>();

    public void addItemToSessionCart(GoodsEntity goodsEntity) {
        int goodsId = goodsEntity.getId();
        if (goodsInCart.containsKey(goodsEntity.getId())) {
            goodsInCart.get(goodsId).setCount(goodsInCart.get(goodsId).getCount() + 1);

        } else {
            CartItemEntity cartItemEntity = new CartItemEntity();
            cartItemEntity.setCount(1);
            cartItemEntity.setGoods(goodsEntity);
            cartItemEntity.setId(goodsId); // TODO maybe its not good
            goodsInCart.put(goodsId, cartItemEntity);
        }
    }

    public List<CartItemEntity> getCartItemsList() {
        List<CartItemEntity> result = new ArrayList<CartItemEntity>();
        result.addAll(goodsInCart.values());
//        if (result == null) {
//            return new ArrayList<CartItemEntity>(); //TODO do something
//        }
        return result;
    }

    public void deleteItemFromCart(int itemId) {
        goodsInCart.remove(itemId);
    }

    public void increaseItemCount(int itemId) {
        goodsInCart.get(itemId).setCount(goodsInCart.get(itemId).getCount() + 1);

    }

    public void decreaseItemCount(int itemId) {
        if (goodsInCart.get(itemId).getCount() > 1) {
            goodsInCart.get(itemId).setCount(goodsInCart.get(itemId).getCount() - 1);
        } else {
            deleteItemFromCart(itemId);
        }

    }
}
