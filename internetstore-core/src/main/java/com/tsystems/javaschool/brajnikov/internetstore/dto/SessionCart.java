package com.tsystems.javaschool.brajnikov.internetstore.dto;

import com.tsystems.javaschool.brajnikov.internetstore.model.CartItemEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Session cart - need to support cart in session scope
 */
@Component("sessionCart")
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
public class SessionCart {
    private Map<Integer, CartItemEntity> goodsInCart = new HashMap<Integer, CartItemEntity>();

    public void addCartItem(GoodsEntity goods, int count) {
        int id = goods.getId();

        if (goodsInCart.containsKey(id)) {
            goodsInCart.get(id).setCount(count);
        } else {
            CartItemEntity cartItemEntity = new CartItemEntity();
            cartItemEntity.setCount(count);
            cartItemEntity.setGoods(goods);

            goodsInCart.put(id, cartItemEntity);
        }
    }
}
