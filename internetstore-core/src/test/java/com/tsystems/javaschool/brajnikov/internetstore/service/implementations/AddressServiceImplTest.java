package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.AddressDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.AddressEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class AddressServiceImplTest {

    @Mock
    private AddressDao addressDao;
    @InjectMocks
    private AddressServiceImpl addressService;


    @Test
    public void updateAddress() {
        initMocks(this);

        AddressEntity address = new AddressEntity();
        address.setId(100);
        when(addressDao.read(100)).thenReturn(address);

        addressService.updateAddress(address);

        verify(addressDao).update(address);
    }

    @Test
    public void findAddressByUserId() {
        initMocks(this);

        when(addressDao.getAddressByUserId(100)).thenReturn(getTestAdress(100));

        AddressEntity address = addressService.findAddressByUserId(100);

        assertNotNull(address);
        assertEquals(100, address.getId());
        assertNotNull(address.getUser());
    }

    private AddressEntity getTestAdress(int i) {
        AddressEntity testAddress = new AddressEntity();
        testAddress.setId(i);
        testAddress.setUser(new UserEntity());
        return testAddress;
    }
}