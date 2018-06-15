package com.tsystems.javaschool.brajnikov.internetstore.dao.implemenations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractGenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.AddressDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.UserDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.AddressEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository
public class AddressDaoImpl extends AbstractGenericDao<AddressEntity,Integer> implements AddressDao {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    UserDao userDao;

    public AddressEntity getAddressByUser(UserEntity user) {
        return user.getAddress();
    }

    @Override
    public AddressEntity getAddressByUserId(int id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from AddressEntity where user = :userParam ");
        query.setParameter("userParam", userDao.findById(id));
        AddressEntity addressEntity;
        try {
            addressEntity = (AddressEntity) query.getSingleResult();
        } catch (NoResultException ex){
            return null;
        }
        return addressEntity;
    }
}
