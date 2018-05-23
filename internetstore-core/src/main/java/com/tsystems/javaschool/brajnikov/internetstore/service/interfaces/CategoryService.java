package com.tsystems.javaschool.brajnikov.internetstore.service.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.model.CategoryEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;

import java.util.List;

/**
 * The interface Category service.
 */
public interface CategoryService {
    /**
     * Gets goods list by category.
     *
     * @param categoryId the category id
     * @return the list of {@link GoodsEntity}
     */
    List<GoodsEntity> getGoodsListByCategory(int categoryId);

    /**
     * Gets category list.
     *
     * @return the list of {@link CategoryEntity}
     */
    List<CategoryEntity> getCategoryList();
}
