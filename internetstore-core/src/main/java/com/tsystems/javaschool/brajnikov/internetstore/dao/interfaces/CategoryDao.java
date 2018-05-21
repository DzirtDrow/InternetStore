package com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dao.GenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.CategoryEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;

import java.util.List;

public interface CategoryDao extends GenericDao<CategoryEntity, Integer> {

    List<GoodsEntity> getGoodsListByCategory(CategoryEntity category);

    List<CategoryEntity> getCategoryList();
}
