package com.tsystems.javaschool.brajnikov.internetstore.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "goods_parameter", schema = "internet_store_db")
@Data
public class GoodsParameterEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "num_value")
    private int numValue;

    @Column(name = "string_value")
    private String stringValue;

    @ManyToOne
    @JoinColumn(name = "goods_id")
    private GoodsEntity goods;

    @ManyToOne
    @JoinColumn(name = "parameter_id")
    private ParameterEntity parameter;

}
