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
            //addressDao.update(addressEntity);
            AddressEntity addr = addressDao.read(addressEntity.getId());
            addr.setUser(addressEntity.getUser());
            addr.setAddress(addressEntity.getAddress());
            addr.setCoordinates(addressEntity.getCoordinates());
            addressDao.update(addr);

            System.out.println(addressEntity.toString());
        } else {
            addressDao.create(addressEntity);
        }
    }
}
