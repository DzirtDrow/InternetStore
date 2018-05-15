package com.tsystems.javaschool.brajnikov.internetstore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Setter @Getter
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

//    @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE)
//    private List<CartItemEntity> carts;

    public OrderEntity() {
    }

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
