package com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dao.GenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.AddressEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;

/**
 * The interface Address dao.
 */
public interface AddressDao extends GenericDao<AddressEntity, Integer>{
    /**
     * Gets address by user.
     *
     * @param user the {@link UserEntity}
     * @return the {@link AddressEntity}
     */
    AddressEntity getAddressByUser(UserEntity user);

    /**
     * Gets address by user id.
     *
     * @param id the id
     * @return the address by user id
     */
    AddressEntity getAddressByUserId(int id);
}
