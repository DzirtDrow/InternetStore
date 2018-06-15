package com.tsystems.javaschool.brajnikov.internetstore.service.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.model.AddressEntity;

/**
 * The interface Address service.
 */
public interface AddressService {
    /**
     * Update address.
     *
     * @param addressEntity the address entity
     */
    void updateAddress(AddressEntity addressEntity);

    AddressEntity findAddressByUserId(int id);
}
