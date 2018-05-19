package com.tsystems.javaschool.brajnikov.internetstore.dao.implemenations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractGenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.CategoryDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.CategoryEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractGenericDao<CategoryEntity, Integer> implements CategoryDao {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<GoodsEntity> getGoodsListByCategory(CategoryEntity category) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from GoodsEntity where category = :categoryParam");
        query.setParameter("categoryParam", category);
        return (List<GoodsEntity>) query.getResultList();
    }


}
