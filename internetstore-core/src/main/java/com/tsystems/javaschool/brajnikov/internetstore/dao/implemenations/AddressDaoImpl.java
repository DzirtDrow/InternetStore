package com.tsystems.javaschool.brajnikov.internetstore.dao.implemenations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractGenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.AddressDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.AddressEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDaoImpl extends AbstractGenericDao<AddressEntity,Integer> implements AddressDao {
    public AddressEntity getAddressByUser(UserEntity user) {
        return user.getAddress();
    }
}
