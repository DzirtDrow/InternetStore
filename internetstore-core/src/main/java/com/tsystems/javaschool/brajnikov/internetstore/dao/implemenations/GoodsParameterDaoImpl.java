package com.tsystems.javaschool.brajnikov.internetstore.dao.implemenations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractGenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.GoodsParameterDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsParameterEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("goodsParameterDao")
public class GoodsParameterDaoImpl extends AbstractGenericDao<GoodsParameterEntity, Integer> implements GoodsParameterDao {
    @Autowired
    private SessionFactory sessionFactory;


}
