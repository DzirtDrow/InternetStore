package com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dao.GenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.CategoryEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.ParameterEntity;

import java.util.List;

/**
 * The interface Category dao.
 */
public interface CategoryDao extends GenericDao<CategoryEntity, Integer> {

    /**
     * Gets goods list by category.
     *
     * @param category {@link CategoryEntity}the category
     * @return the goods list
     */
    List<GoodsEntity> getGoodsListByCategory(CategoryEntity category);

    /**
     * Gets category list.
     *
     * @return the category list
     */
    List<CategoryEntity> getCategoryList();


    List<ParameterEntity> getParameterListByCategory(CategoryEntity category);
}
