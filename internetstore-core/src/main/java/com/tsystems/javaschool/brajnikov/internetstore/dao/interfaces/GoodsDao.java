package com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dao.GenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.CategoryEntity;
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

    /**
     * Gets top list.
     *
     * @param count the count
     * @return the top list
     */
    List<GoodsEntity> getTopList(int count);

    /**
     * Find category by goods category entity.
     *
     * @param goods the goods
     * @return the category entity
     */
    CategoryEntity findCategoryByGoods(GoodsEntity goods);
}
