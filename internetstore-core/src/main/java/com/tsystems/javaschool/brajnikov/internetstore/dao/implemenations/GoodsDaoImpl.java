package com.tsystems.javaschool.brajnikov.internetstore.dao.implemenations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractGenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.GoodsDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.CategoryEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository("goodsDao")
public class GoodsDaoImpl extends AbstractGenericDao<GoodsEntity, Integer> implements GoodsDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<GoodsEntity> findAllGoods() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from GoodsEntity order by id asc");
        return (List<GoodsEntity>) query.getResultList();
    }

    @Override
    public List<GoodsEntity> getTopList(int count) {
            Query query = sessionFactory.getCurrentSession()
                .createQuery("from GoodsEntity where status = 'ACTIVE' order by salesCount desc");
        List<GoodsEntity> queryResult = (List<GoodsEntity>) query.getResultList();
        int t = count;
        if (queryResult.size() < count) {
            t = queryResult.size();
        }
        List<GoodsEntity> result = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            result.add(queryResult.get(i));

        }
        return result;
    }

    @Override
    public CategoryEntity findCategoryByGoods(GoodsEntity goods) {
        return null;
    }

}
