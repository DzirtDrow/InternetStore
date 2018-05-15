package com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dao.GenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartItemEntity;

import java.util.List;

public interface CartDao extends GenericDao<CartItemEntity, Integer> {
    CartEntity findCartsByUserId();

}
