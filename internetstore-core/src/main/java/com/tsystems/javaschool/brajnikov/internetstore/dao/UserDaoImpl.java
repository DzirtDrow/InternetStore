package com.tsystems.javaschool.brajnikov.internetstore.dao;

import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl extends AbstractDao<Integer, UserEntity> implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private SessionFactory sessionFactory;

    public UserEntity findById(int id) {
        UserEntity user = getByKey(id);
        return user;
    }

    public void save(UserEntity user) {

    }


    public List<UserEntity> findAllUsers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("email"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<UserEntity> users = (List<UserEntity>) criteria.list();

        return users;
    }
}
