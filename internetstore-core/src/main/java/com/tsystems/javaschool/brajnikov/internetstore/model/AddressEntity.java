package com.tsystems.javaschool.brajnikov.internetstore.model;

import javax.persistence.*;

@Entity
@Table(name = "user_address")
public class AddressEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Basic
    @Column(name = "address")
    private String address;

    @Basic
    @Column(name = "coordinates")
    private String coordinates;



}
