package com.tsystems.javaschool.brajnikov.internetstore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter @Getter
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
