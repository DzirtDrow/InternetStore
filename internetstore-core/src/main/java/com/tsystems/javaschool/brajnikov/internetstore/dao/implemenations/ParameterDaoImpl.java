package com.tsystems.javaschool.brajnikov.internetstore.dao.implemenations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractGenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.ParameterDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.ParameterEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository("parameterDao")
public class ParameterDaoImpl extends AbstractGenericDao<ParameterEntity, Integer> implements ParameterDao {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public ParameterEntity findByName(String name) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from ParameterEntity where name = :nameParam");
        query.setParameter("nameParam", name);
        ParameterEntity result;
        try{
             result = (ParameterEntity)query.getSingleResult();
        } catch (NoResultException ex){
            return null;
        }
        return result;
    }
}
