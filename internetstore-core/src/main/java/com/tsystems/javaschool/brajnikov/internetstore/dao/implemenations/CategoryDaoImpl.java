package com.tsystems.javaschool.brajnikov.internetstore.dao.implemenations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractGenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.CategoryDao;
import com.tsystems.javaschool.brajnikov.internetstore.enums.SortingTypeEnum;
import com.tsystems.javaschool.brajnikov.internetstore.model.CategoryEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.ParameterEntity;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractGenericDao<CategoryEntity, Integer> implements CategoryDao {
    @Autowired
    private SessionFactory sessionFactory;

    static final Logger logger = LoggerFactory.getLogger(CategoryDaoImpl.class);
    @SuppressWarnings("unchecked")
    public List<GoodsEntity> getGoodsListByCategory(CategoryEntity category) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from GoodsEntity where category = :categoryParam and status = 'ACTIVE'");
        query.setParameter("categoryParam", category);
        return (List<GoodsEntity>) query.getResultList();
    }

    public List<CategoryEntity> getCategoryList() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from CategoryEntity");
        return (List<CategoryEntity>) query.getResultList();
    }


    public List<ParameterEntity> getParameterListByCategory(CategoryEntity category) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from ParameterEntity where CategoryEntity =:categoryParam");
        query.setParameter("categoryParam", category);
        List<ParameterEntity> result;
        try {
            result = (List<ParameterEntity>) query.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
        return result;
    }

    @Override
    public List<GoodsEntity> getGoodsListByFilter(CategoryEntity category,
                                                  Integer priceMin,
                                                  Integer priceMax,
                                                  String sorttype) {

        if ((priceMin == null) || (priceMax == null)) {
            priceMin = 0;
            priceMax = Integer.MAX_VALUE;
        }
        SortingTypeEnum ste = SortingTypeEnum.ASC;
        if (sorttype != null) {
            ste = SortingTypeEnum.valueOf(sorttype);
        }
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from GoodsEntity " +
                        " where category = :categoryParam " +
                        " and price >= :priceMinParam  " +
                        " and price <= :priceMaxParam " +
                        " and status = 'ACTIVE'" +
                        " order by price " + ste);
        query.setParameter("categoryParam", category);
        query.setParameter("priceMinParam", priceMin);
        query.setParameter("priceMaxParam", priceMax);
        return (List<GoodsEntity>) query.getResultList();
    }

    @Override
    public Integer getMaxPriceForCategory(CategoryEntity categoryEntity) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from GoodsEntity where category = :categoryParam order by price desc");
        query.setParameter("categoryParam", categoryEntity);
        List<GoodsEntity> goodsEntityList;
        try {
             goodsEntityList = (List<GoodsEntity>) query.getResultList();
        } catch (NoResultException ex){
            return 0;
        }
        if(goodsEntityList.isEmpty()){
            return 0;
        }
        GoodsEntity goods = goodsEntityList.get(0);
        return goods.getPrice();
    }

    @Override
    public CategoryEntity findCategoryByName(String name) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from CategoryEntity where name = :paramName");
        query.setParameter("paramName", name);

        CategoryEntity categoryEntity = null;
        try {
            categoryEntity = (CategoryEntity) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return categoryEntity;
    }

    @Override
    public boolean deleteCategoryById(Integer id) {
        try {
            delete(read(id));
        } catch (Exception e) {
            logger.error("Exception in CategoryDaoImpl in deleteCategoryById method {}", e);
            return false;
        }
        return true;
    }


}
