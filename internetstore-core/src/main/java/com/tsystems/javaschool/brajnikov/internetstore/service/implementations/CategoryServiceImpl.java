package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.CategoryDao;
import com.tsystems.javaschool.brajnikov.internetstore.dto.CategoryDto;
import com.tsystems.javaschool.brajnikov.internetstore.model.CategoryEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.ParameterEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.CategoryService;
import com.tsystems.javaschool.brajnikov.internetstore.util.ModelMapperWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    ModelMapperWrapper modelMapperWrapper;

    public List<GoodsEntity> getGoodsListByCategory(int categoryId) {
        return categoryDao.getGoodsListByCategory(categoryDao.read(categoryId));
    }

    public List<CategoryEntity> getCategoryList() {
        return categoryDao.getCategoryList();
    }

    public CategoryEntity getCategoryById(int categoryId){
     return categoryDao.read(categoryId);
    }

    public List<ParameterEntity> getParametersByCategory(CategoryEntity categoryEntity){
        return categoryDao.getParameterListByCategory(categoryEntity);
    }

    @Override
    public List<CategoryDto> getCategoryDtoList() {
        return categoryDao.getCategoryList()
                .stream()
                .map(modelMapperWrapper::mapCategory)
                .collect(Collectors.toList());
    }

    @Override
    public void updateCategory(CategoryEntity categoryEntity) {
        categoryDao.update(categoryEntity);
    }

    @Override
    public List<GoodsEntity> getGoodsListByFilter(CategoryEntity category, Integer priceMin, Integer priceMax, String sorttype) {
        return categoryDao.getGoodsListByFilter(category, priceMin, priceMax, sorttype);
    }

    @Override
    public Integer getMaxPriceForCategory(CategoryEntity categoryEntity) {
        return categoryDao.getMaxPriceForCategory(categoryEntity);
    }


}
