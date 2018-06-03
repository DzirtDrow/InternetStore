package com.tsystems.javaschool.brajnikov.internetstore.model;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Category entity.
 */
@Entity
@Table(name = "category")
@Data
public class CategoryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<GoodsEntity> goodsList;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @JoinTable(name = "category_parameter",
                joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "parameter_id"))
    private List<ParameterEntity> parameters = new ArrayList<ParameterEntity>();
}
