package com.tsystems.javaschool.brajnikov.internetstore.dao.implemenations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractGenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.UserDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractGenericDao<UserEntity, Integer> implements UserDao {

//    @PersistenceContext
//    private EntityManager entityManager;

    @Autowired
    private SessionFactory sessionFactory;


    public UserEntity findById(int id) {
        UserEntity user = read(id);
        return user;
    }

    public UserEntity findByEmail(String email) {
        Query query = sessionFactory.getCurrentSession().createQuery("from UserEntity where email = :paramName");
        query.setParameter("paramName", email);
        return (UserEntity)query.getResultList().get(0); //TODO
    }

    public UserEntity findByName(String username) {
        Query query = sessionFactory.getCurrentSession().createQuery("from UserEntity where name = :paramName");
        query.setParameter("paramName", username);
        return (UserEntity)query.getResultList().get(0);
    }


    public void save(UserEntity user) {
        save(user);
    }

    public List<UserEntity> findAllUsers() {
        //Criteria criteria = createEntityCriteria().addOrder(Order.asc("email"));
        //criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<UserEntity> users = getList();//(List<UserEntity>) criteria.list();
        return users;
    }

    public UserEntity getActiveUser(String email) {
        UserEntity activeUserInfo = findByEmail(email);

//        if(activeUserInfo != null) {
//            activeUserInfo = (UserInfo)list.get(0);
//        }
        return activeUserInfo;
    }
}
