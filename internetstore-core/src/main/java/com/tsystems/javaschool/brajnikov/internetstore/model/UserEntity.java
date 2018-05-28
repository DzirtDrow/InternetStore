package com.tsystems.javaschool.brajnikov.internetstore.model;

import com.tsystems.javaschool.brajnikov.internetstore.util.RoleEnum;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The type User entity.
 */
@Entity
@Data
@Table(name = "user")
public class UserEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthdate")
    private Date date;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<OrderEntity> orders;

    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    private CartEntity cart;

    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private AddressEntity address;

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", date=" + date +
                ", role=" + role +
                '}';
    }

}