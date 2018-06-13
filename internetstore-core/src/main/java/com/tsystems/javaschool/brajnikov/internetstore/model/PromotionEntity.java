package com.tsystems.javaschool.brajnikov.internetstore.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "promotion")
public class PromotionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

}
