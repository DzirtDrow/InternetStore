package com.tsystems.javaschool.brajnikov.internetstore.service.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dto.SessionCart;
import com.tsystems.javaschool.brajnikov.internetstore.exception.CartIsEmptyException;
import com.tsystems.javaschool.brajnikov.internetstore.exception.NoGoodsInStockException;
import com.tsystems.javaschool.brajnikov.internetstore.exception.OrdersNotFoundException;
import com.tsystems.javaschool.brajnikov.internetstore.model.*;
import com.tsystems.javaschool.brajnikov.internetstore.enums.SortingTypeEnum;

import java.util.List;

/**
 * The interface Order service.
 */
public interface OrderService {

    /**
     * Create order.
     *
     * @param orderEntity the order entity
     */
    void createOrder(OrderEntity orderEntity);

    /**
     * Create order by cart.
     *
     * @param cartEntity  {@link CartEntity} cart
     * @return Id of the created order
     * @throws CartIsEmptyException the cart is empty exception
     */
    int createOrderByCart(CartEntity cartEntity) throws CartIsEmptyException, NoGoodsInStockException;

    /**
     * Gets order by id.
     *
     * @param id the id
     * @return  {@link OrderEntity} order
     */
    OrderEntity getOrderById(Integer id);

    /**
     * Gets all orders.
     *
     * @return the list of {@link OrderEntity}
     */
    List<OrderEntity> getAllOrders();

    /**
     * Gets orders list by user.
     *
     * @param user the user {@link UserEntity}
     * @return the orders list
     * @throws OrdersNotFoundException the orders not found exception
     */
    List<OrderEntity> getOrdersListByUser(UserEntity user) throws OrdersNotFoundException;

    /**
     * Update order.
     *
     * @param orderEntity the order entity
     */
    void updateOrder(OrderEntity orderEntity);

    /**
     * Push order status.
     *
     * @param orderEntity the order entity
     */
    void pushOrderStatus(OrderEntity orderEntity);

    List<OrderEntity> getAllOrdersOrderByDate(SortingTypeEnum type);

    List<OrderEntity> getAllOrdersOrderByStatus(SortingTypeEnum type);

    void createOrderFromSessionCart(UserEntity user, SessionCart sessionCart);

    Integer getWeekProceed();
    Integer getMonthProceed();

    Integer reorderById(Integer orderId);
}
