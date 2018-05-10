package com.tsystems.javaschool.brajnikov.internetstore.dao.implemenations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.UserDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, UserEntity> implements UserDao {

//    @PersistenceContext
//    private EntityManager entityManager;

    @Autowired
    private SessionFactory sessionFactory;


    public UserEntity findById(int id) {
        UserEntity user = getByKey(id);
        return user;
    }

    public UserEntity findByEmail(String email) {
        return null; //TODO
    }


    public void save(UserEntity user) {
        persist(user);
    }

    public List<UserEntity> findAllUsers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("email"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<UserEntity> users = (List<UserEntity>) criteria.list();

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
