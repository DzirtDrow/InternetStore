package com.tsystems.javaschool.brajnikov.internetstore.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cart")
public class CartEntity implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private List<CartItemEntity> cartItems;

    public CartEntity() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CartItemEntity> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemEntity> cartItems) {
        this.cartItems = cartItems;
    }
    public void addCartItem(CartItemEntity cartItemEntity) {
        this.cartItems.add(cartItemEntity);
    }
}
