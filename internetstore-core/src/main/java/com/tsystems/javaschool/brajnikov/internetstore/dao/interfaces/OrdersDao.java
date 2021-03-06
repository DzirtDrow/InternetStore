package com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dao.GenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.exception.OrdersNotFoundException;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.OrderEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import com.tsystems.javaschool.brajnikov.internetstore.enums.SortingTypeEnum;

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

    /**
     * Gets orders by goods.
     *
     * @param goods the goods
     * @return the orders by goods
     */
    List<OrderEntity> getOrdersByGoods(GoodsEntity goods);

    /**
     * Gets all orders order by date.
     *
     * @param type the type
     * @return the all orders order by date
     */
    List<OrderEntity> getAllOrdersOrderByDate(SortingTypeEnum type);

    /**
     * Gets all orders order by status.
     *
     * @param type the type
     * @return the all orders order by status
     */
    List<OrderEntity> getAllOrdersOrderByStatus(SortingTypeEnum type);

    /**
     * Gets week proceed.
     *
     * @return the week proceed
     */
    Integer getWeekProceed();

    /**
     * Gets month proceed.
     *
     * @return the month proceed
     */
    Integer getMonthProceed();
}
