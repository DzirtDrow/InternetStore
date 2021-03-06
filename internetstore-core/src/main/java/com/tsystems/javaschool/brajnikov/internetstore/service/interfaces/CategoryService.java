package com.tsystems.javaschool.brajnikov.internetstore.service.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dto.CategoryDto;
import com.tsystems.javaschool.brajnikov.internetstore.model.CategoryEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.ParameterEntity;

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

    CategoryEntity getCategoryById(int categoryId);

    List<ParameterEntity> getParametersByCategory(CategoryEntity categoryEntity);

    List<CategoryDto> getCategoryDtoList();

    void updateCategory(CategoryEntity categoryEntity);

    List<GoodsEntity> getGoodsListByFilter(CategoryEntity category, Integer priceMin, Integer priceMax, String sorttype);

    Integer getMaxPriceForCategory(CategoryEntity categoryEntity);

    CategoryEntity findCategoryByName(String name);

    Integer addCategory(CategoryEntity category);

    boolean deleteCategoryById(Integer id);
}
