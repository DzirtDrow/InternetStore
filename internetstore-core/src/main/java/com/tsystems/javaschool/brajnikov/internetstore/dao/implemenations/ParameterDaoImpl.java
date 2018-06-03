package com.tsystems.javaschool.brajnikov.internetstore.dao.implemenations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractGenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.ParameterDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.ParameterEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("parameterDao")
public class ParameterDaoImpl extends AbstractGenericDao<ParameterEntity, Integer> implements ParameterDao {
    @Autowired
    private SessionFactory sessionFactory;


}
