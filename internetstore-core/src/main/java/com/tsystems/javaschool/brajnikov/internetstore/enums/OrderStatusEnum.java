package com.tsystems.javaschool.brajnikov.internetstore.enums;

/**
 * The enum Order status enum.
 */
public enum OrderStatusEnum {
    /**
     * Processing order status.
     */
    PROCESSING("Processing"),
    /**
     * Pending payment order status.
     */
    PENDING_PAYMENT("Waiting for payment"),
    /**
     * Pending shipping order status.
     */
    PENDING_SHIPPING("Waiting for shipping"),
    /**
     * Shipped order status.
     */
    SHIPPED("Shipped"),
    /**
     * Delivered order status.
     */
    DELIVERED("Delivered");

    private String text;

    OrderStatusEnum(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
