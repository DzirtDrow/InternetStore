package com.tsystems.javaschool.brajnikov.internetstore.dao.implemenations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractGenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.GoodsDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("goodsDao")
public class GoodsDaoImpl extends AbstractGenericDao<GoodsEntity,Integer> implements GoodsDao {
//    @PersistenceContext
//    private EntityManager entityManager;

    @Autowired
    private SessionFactory sessionFactory;

    public List<GoodsEntity> findAllGoods() {
        return getList();
    }

}
