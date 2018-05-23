package com.tsystems.javaschool.brajnikov.internetstore.model;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * The type Persistent login.
 */
@Entity
@Data
@Table(name="PERSISTENT_LOGINS")
public class PersistentLogin implements Serializable {

    @Id
    private String series;

    @Column(name="USERNAME", unique=true, nullable=false)
    private String username;

    @Column(name="TOKEN", unique=true, nullable=false)
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    private Date last_used;


}
