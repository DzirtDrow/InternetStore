package com.tsystems.javaschool.brajnikov.internetstore.model;

import com.tsystems.javaschool.brajnikov.internetstore.enums.CartItemTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The type Cart item entity.
 */
@Entity
@Setter
@Getter
@Table(name = "cart_item")
public class CartItemEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "goods_id")
    private GoodsEntity goods;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cart;

    @Basic
    @Column(name = "count")
    private int count;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private CartItemTypeEnum type;

}
