package com.tsystems.javaschool.brajnikov.internetstore.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The type Address entity.
 */
@Entity
@Data
@Table(name = "user_address")
public class AddressEntity implements Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "address")
    private String address;

    @Column(name = "coordinates")
    private String coordinates;

}
