package com.tsystems.javaschool.brajnikov.internetstore.service.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.model.CategoryEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;

import java.util.List;

public interface CategoryService {
    List<GoodsEntity> getGoodsListByCategory(int categoryId);
    List<CategoryEntity> getCategoryList();
}
