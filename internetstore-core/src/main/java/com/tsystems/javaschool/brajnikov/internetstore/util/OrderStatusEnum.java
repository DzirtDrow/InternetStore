package com.tsystems.javaschool.brajnikov.internetstore.util;

/**
 * The enum Order status enum.
 */
public enum OrderStatusEnum {
    /**
     * Processing order status.
     */
    PROCESSING, /**
     * Pending payment order status.
     */
    PENDING_PAYMENT, /**
     * Pending shipping order status.
     */
    PENDING_SHIPPING, /**
     * Shipped order status.
     */
    SHIPPED, /**
     * Delivered order status.
     */
    DELIVERED
}
