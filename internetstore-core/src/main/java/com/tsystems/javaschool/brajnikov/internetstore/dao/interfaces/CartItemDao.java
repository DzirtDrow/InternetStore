package com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dao.GenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartItemEntity;

public interface CartItemDao extends GenericDao<CartItemEntity, Integer> {
    void deleteItemById(int id);
}
