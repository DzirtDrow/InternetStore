package com.tsystems.javaschool.brajnikov.internetstore.model;

import com.tsystems.javaschool.brajnikov.internetstore.util.ParameterTypeEnum;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "parameter")
@Data
public class ParameterEntity implements Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;


    @Enumerated(EnumType.STRING)
    @Column(name = "param_type")
    private ParameterTypeEnum parameterType;

//    @ManyToMany(mappedBy = "parameters", fetch = FetchType.EAGER)
//    @JoinTable(name = "category_parameter",
//            joinColumns = @JoinColumn(name = "parameter_id"),
//            inverseJoinColumns = @JoinColumn(name = "category_id"))
//    private List<CategoryEntity> categories = new ArrayList<CategoryEntity>();




}
