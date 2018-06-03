package com.tsystems.javaschool.brajnikov.internetstore.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * The type Goods entity.
 */
@Entity
@Table(name = "goods", schema = "internet_store_db")
@Data
public class GoodsEntity implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Basic
    @Column(name = "price")
    private Integer price;

    @Column(name = "description")
    private String description;

    @Column(name = "left_count")
    private int leftCount;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @OneToMany(mappedBy = "goods", fetch = FetchType.EAGER)
    private List<GoodsParameterEntity> goodsParameterList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsEntity that = (GoodsEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GoodsEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
