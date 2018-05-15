package com.tsystems.javaschool.brajnikov.internetstore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Setter @Getter
@Table(name = "cart_item")
public class CartItemEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "goods_id")
    private GoodsEntity goods;

    @Basic
    @Column(name = "count")
    private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GoodsEntity getGoods() {
        return goods;
    }

    public void setGoods(GoodsEntity goods) {
        this.goods = goods;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
