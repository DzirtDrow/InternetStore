package com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dao.GenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.exception.OrdersNotFoundException;
import com.tsystems.javaschool.brajnikov.internetstore.model.OrderEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;

import java.util.List;

/**
 * The interface Orders dao.
 */
public interface OrdersDao extends GenericDao<OrderEntity, Integer> {

    /**
     * Gets orders list by user.
     *
     * @param userEntity {@link UserEntity} the user entity
     * @return list of {@link OrderEntity}
     * @throws OrdersNotFoundException the orders not found exception
     */
    List<OrderEntity> getOrdersByUser(UserEntity userEntity) throws OrdersNotFoundException;

    /**
     * Gets orders list.
     *
     * @return the list of {@link OrderEntity}
     */
    List<OrderEntity> getOrdersList();
}
