package com.tsystems.javaschool.brajnikov.internetstore.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart")
public class CartEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @OneToOne
    @JoinColumn(name = "goods_id")
    private GoodsEntity goods;

    @Basic
    @Column(name = "count")
    private int count;

}
