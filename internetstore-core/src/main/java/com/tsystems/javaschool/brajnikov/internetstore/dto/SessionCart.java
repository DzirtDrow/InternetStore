package com.tsystems.javaschool.brajnikov.internetstore.dto;

import com.tsystems.javaschool.brajnikov.internetstore.model.CartItemEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import lombok.Data;
import org.springframework.stereotype.Component;

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

   // private int cartTotalPrice;

    /**
     * Gets cart total price.
     *
     * @return the cart total price
     */
    public int getCartTotalPrice() {
        int cartTotalPrice = 0;
        for (CartItemEntity item : goodsInCart.values()) {
            cartTotalPrice += item.getCount() * item.getGoods().getPrice();
        }
        return cartTotalPrice;
    }

    private Map<Integer, CartItemEntity> goodsInCart = new HashMap<Integer, CartItemEntity>();

    /**
     * Add item to session cart.
     *
     * @param goodsEntity the goods entity
     */
    public void addItemToSessionCart(GoodsEntity goodsEntity) {
        int goodsId = goodsEntity.getId();
        if (goodsInCart.containsKey(goodsEntity.getId())) {
            goodsInCart.get(goodsId).setCount(goodsInCart.get(goodsId).getCount() + 1);

        } else {
            CartItemEntity cartItemEntity = new CartItemEntity();
            cartItemEntity.setCount(1);
            cartItemEntity.setGoods(goodsEntity);
            cartItemEntity.setId(goodsId);
            goodsInCart.put(goodsId, cartItemEntity);
        }
    }

    /**
     * Gets cart items list.
     *
     * @return the list of {@link CartItemEntity}
     */
    public List<CartItemEntity> getCartItemsList() {
        List<CartItemEntity> result = new ArrayList<CartItemEntity>();
        result.addAll(goodsInCart.values());
        return result;
    }

    /**
     * Delete item from cart by item id.
     *
     * @param itemId the item id
     */
    public void deleteItemFromCart(int itemId) {
        goodsInCart.remove(itemId);
    }

    /**
     * Increase item count.
     *
     * @param itemId the item id
     */
    public void increaseItemCount(int itemId) {
        goodsInCart.get(itemId).setCount(goodsInCart.get(itemId).getCount() + 1);

    }

    /**
     * Decrease item count.
     *
     * @param itemId the item id
     */
    public void decreaseItemCount(int itemId) {
        if (goodsInCart.get(itemId).getCount() > 1) {
            goodsInCart.get(itemId).setCount(goodsInCart.get(itemId).getCount() - 1);
        } else {
            deleteItemFromCart(itemId);
        }

    }
}
