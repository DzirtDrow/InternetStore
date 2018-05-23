package com.tsystems.javaschool.brajnikov.internetstore.dao.implemenations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractGenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.AddressDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.UserDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractGenericDao<UserEntity, Integer> implements UserDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private AddressDao adressDao;


    public UserEntity findById(int id) {
        return read(id);
    }

    public UserEntity findByEmail(String email) {
        Query query = sessionFactory.getCurrentSession().createQuery("from UserEntity where email = :paramName");
        query.setParameter("paramName", email);

        UserEntity userEntity = null;
        try {
            userEntity = (UserEntity)query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return userEntity;
    }

    public UserEntity findByName(String username) {
        Query query = sessionFactory.getCurrentSession().createQuery("from UserEntity where name = :paramName");
        query.setParameter("paramName", username);
        return (UserEntity)query.getSingleResult();
    }




    public void save(UserEntity user) {
        save(user);
    }

    public List<UserEntity> findAllUsers() {
        List<UserEntity> users = getList();
        return users;
    }

    public UserEntity getActiveUser(String email) {
        UserEntity activeUserInfo = findByEmail(email);

        return activeUserInfo;
    }
}
