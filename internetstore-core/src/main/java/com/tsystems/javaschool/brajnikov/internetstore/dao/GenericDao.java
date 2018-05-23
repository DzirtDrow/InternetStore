package com.tsystems.javaschool.brajnikov.internetstore.dao;


import java.io.Serializable;
import java.util.List;

/**
 * The interface Generic dao.
 *
 * @param <T>  the Entity parameter type
 * @param <PK> the Primary Key parameter type
 */
public interface GenericDao<T, PK extends Serializable> {

    /**
     * Save object to batabase
     * @param newInstance new instance of T object
     *
     * @return the id of the object
     */
    PK create(T newInstance);

    /**
     * Get object from database
     *
     * @param id the id of the object
     * @return the instance of T object from database
     */
    T read(PK id);

    /**
     * Save changed object T in database
     * @param transientObject the transient object to save
     */
    void update(T transientObject);

    /**
     * Delete object T from database
     * @param persistentObject the persistent object to delete
     */
    void delete(T persistentObject);

    /**
     * Gets list.
     *
     * @return the list of Entity T
     */
    List<T> getList();
    }
