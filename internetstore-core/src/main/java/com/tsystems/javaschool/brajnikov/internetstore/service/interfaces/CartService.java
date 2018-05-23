package com.tsystems.javaschool.brajnikov.internetstore.service.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.model.CartEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartItemEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;

import java.util.List;

/**
 * The interface Cart service.
 */
public interface CartService {
    /**
     * Add goods to cart by user id.
     *
     * @param userId      the user id
     * @param goodsEntity the {@link GoodsEntity}
     */
    void addGoodsToCart(int userId, GoodsEntity goodsEntity);

    /**
     * Gets cart items by user id.
     *
     * @param userId the user id
     * @return the list of {@link CartItemEntity}
     */
    List<CartItemEntity> getCartItems(int userId);

    /**
     * Delete cart item by id.
     *
     * @param itemId the item id
     */
    void deleteCartItem(int itemId);

    /**
     * Increase items count.
     *
     * @param itemId the item id
     */
    void increaseItemsCount(int itemId);

    /**
     * Decrease items count.
     *
     * @param itemId the item id
     */
    void decreaseItemsCount(int itemId);

    /**
     * Load session cart.
     *
     * @param id the id
     */
    void loadSessionCart(int id);

    /**
     * Gets cart total price.
     *
     * @param userId the user id
     * @return the cart total price
     */
    int getCartTotalPrice(int userId) ;

    /**
     * Gets cart by user.
     *
     * @param user the user
     * @return the cart by user
     */
    CartEntity getCartByUser(UserEntity user);
}
