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


    /**
     * Gets parameter list by category.
     *
     * @param category the category
     * @return the parameter list by category
     */
    List<ParameterEntity> getParameterListByCategory(CategoryEntity category);

    /**
     * Gets goods list by filter.
     *
     * @param category the category
     * @param priceMin the price min
     * @param priceMax the price max
     * @param sorttype the sorttype
     * @return the goods list by filter
     */
    List<GoodsEntity> getGoodsListByFilter(CategoryEntity category, Integer priceMin, Integer priceMax, String sorttype);

    /**
     * Gets max price for category.
     *
     * @param categoryEntity the category entity
     * @return the max price for category
     */
    Integer getMaxPriceForCategory(CategoryEntity categoryEntity);

    /**
     * Find category by name category entity.
     *
     * @param name the name
     * @return the category entity
     */
    CategoryEntity findCategoryByName(String name);

    /**
     * Delete category by id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean deleteCategoryById(Integer id);

}
