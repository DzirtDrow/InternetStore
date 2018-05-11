package com.tsystems.javaschool.brajnikov.internetstore.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order", schema = "internet_store_db")
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "order")
    private List<CartEntity> carts;

}
