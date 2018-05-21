package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.AddressDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.AddressEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    public void updateAddress(AddressEntity addressEntity, String address) {
        addressEntity.setAddress(address);
        if(addressDao.read(addressEntity.getId())!= null){
            addressDao.update(addressEntity);
        } else {
            addressDao.create(addressEntity);
        }
    }
}