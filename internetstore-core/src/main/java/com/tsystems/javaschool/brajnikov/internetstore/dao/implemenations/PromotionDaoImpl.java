package com.tsystems.javaschool.brajnikov.internetstore.dao.implemenations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractGenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.PromotionDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.PromotionEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class PromotionDaoImpl extends AbstractGenericDao<PromotionEntity, Integer> implements PromotionDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<PromotionEntity> getPromotionList() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from PromotionEntity");
        return (List<PromotionEntity>) query.getResultList();
    }
}
