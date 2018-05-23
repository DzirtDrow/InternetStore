package com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dao.GenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;

import java.util.List;

/**
 * The interface Goods dao.
 */
public interface GoodsDao extends GenericDao<GoodsEntity, Integer> {
    /**
     * Find all goods list.
     *
     * @return the list of {@link GoodsEntity}
     */
    List<GoodsEntity> findAllGoods();
}
