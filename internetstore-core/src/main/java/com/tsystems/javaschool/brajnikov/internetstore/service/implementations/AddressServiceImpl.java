package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.AddressDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.AddressEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Transactional
    public void updateAddress(AddressEntity addressEntity) {
        if (addressDao.read(addressEntity.getId()) != null) {
            AddressEntity addr = addressDao.read(addressEntity.getId());
            addr.setUser(addressEntity.getUser());
            addr.setAddress(addressEntity.getAddress());
            addr.setCoordinates(addressEntity.getCoordinates());
            addressDao.update(addr);
        } else {
            addressDao.create(addressEntity);
        }
    }

    @Override
    @Transactional
    public AddressEntity findAddressByUserId(int id) {

        return addressDao.getAddressByUserId(id);
    }
}
