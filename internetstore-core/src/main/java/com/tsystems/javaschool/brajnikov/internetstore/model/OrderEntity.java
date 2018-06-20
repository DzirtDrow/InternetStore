package com.tsystems.javaschool.brajnikov.internetstore.model;

import com.tsystems.javaschool.brajnikov.internetstore.enums.OrderDeliveryTypeEnum;
import com.tsystems.javaschool.brajnikov.internetstore.enums.OrderPaymentMethodEnum;
import com.tsystems.javaschool.brajnikov.internetstore.enums.OrderStatusEnum;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * The type Order entity.
 */
@Entity
@Data
@Table(name = "orders", schema = "internet_store_db")
public class OrderEntity implements Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "order_date")
    private Date order_date;

    @Basic
    @Column(name = "sum")
    private int sum;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum status;

    @Column(name = "pay_method")
    @Enumerated(EnumType.STRING)
    private OrderPaymentMethodEnum paymentMethod;

    @Column(name = "delivery_type")
    @Enumerated(EnumType.STRING)
    private OrderDeliveryTypeEnum deliveryType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<CartItemEntity> orderItems;


    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", order_date=" + order_date +
                ", sum=" + sum +
                ", user=" + user +
                '}';
    }
}
