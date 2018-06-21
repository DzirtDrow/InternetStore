package com.tsystems.javaschool.brajnikov.internetstore.dao.implemenations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractGenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.UserDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractGenericDao<UserEntity, Integer> implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

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

    public List<UserEntity> findAllUsers() {
        return getList();
    }

    @Override
    public void updateSpentCount(UserEntity user, int summ) {
        user.setSpentCount(user.getSpentCount() + summ);
        update(user);
    }

    @Override
    public List<UserEntity> getTopUsers(int count) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from UserEntity order by spentCount desc");
        List<UserEntity> queryResult = (List<UserEntity>) query.getResultList();
        int t = count;
        if (queryResult.size() < count) {
            t = queryResult.size();
        }
        List<UserEntity> result = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            result.add(queryResult.get(i));

        }
        return result;
    }

}
