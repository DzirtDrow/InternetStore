package com.tsystems.javaschool.brajnikov.internetstore.model;

import com.tsystems.javaschool.brajnikov.internetstore.util.OrderStatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Setter @Getter
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<CartItemEntity> orderItems;

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
//    @JoinColumn(name = "order_id", referencedColumnName = "id")
//    private List<CartItemEntity> orderItems;

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
