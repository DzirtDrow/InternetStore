package com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dao.GenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartItemEntity;

/**
 * The interface Cart item dao.
 */
public interface CartItemDao extends GenericDao<CartItemEntity, Integer> {
    /**
     * Delete item from cart by id.
     *
     * @param id the id
     */
    void deleteItemById(int id);
}
