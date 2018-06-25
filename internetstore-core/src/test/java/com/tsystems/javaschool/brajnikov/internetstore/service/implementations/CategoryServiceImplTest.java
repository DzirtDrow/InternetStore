package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.CategoryDao;
import com.tsystems.javaschool.brajnikov.internetstore.dto.CategoryDto;
import com.tsystems.javaschool.brajnikov.internetstore.model.CategoryEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.ParameterEntity;
import com.tsystems.javaschool.brajnikov.internetstore.util.ModelMapperWrapper;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class CategoryServiceImplTest {

    @Mock
    private CategoryDao categoryDao;
    @Mock
    @Autowired
    private ModelMapperWrapper modelMapperWrapper;
    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    public void getGoodsListByCategory() {
        initMocks(this);
        CategoryEntity testCategory = new CategoryEntity();
        testCategory.setId(100);
        testCategory.setGoodsList(getTestGoodsList());

        when(categoryDao.read(100)).thenReturn(testCategory);
        when(categoryDao.getGoodsListByCategory(testCategory)).thenReturn(getTestGoodsList());

        List<GoodsEntity> goodsEntitiesList = categoryService.getGoodsListByCategory(100);

        assertNotNull(goodsEntitiesList);
        assertEquals(getTestGoodsList(), goodsEntitiesList);


    }


    @Test
    public void getCategoryList() {
        initMocks(this);

        when(categoryDao.getCategoryList()).thenReturn(getTestCategoryList());

        List<CategoryEntity> testCategoryList = categoryService.getCategoryList();

        assertNotNull(testCategoryList);
        assertEquals(getTestCategoryList(), testCategoryList);
    }

    @Test
    public void getCategoryById() {
        initMocks(this);

        when(categoryDao.read(100)).thenReturn(getTestCategory(100));

        CategoryEntity category = categoryService.getCategoryById(100);

        assertNotNull(category);
        assertEquals(100, category.getId());
        assertEquals(getTestCategory(100), category);

    }

    @Test
    public void getParametersByCategory() {
        initMocks(this);
        CategoryEntity testCategory = new CategoryEntity();
        when(categoryDao.getParameterListByCategory(testCategory)).thenReturn(getTestParameterList());

        List<ParameterEntity> testParameterList = categoryService.getParametersByCategory(testCategory);

        assertNotNull(testParameterList);
        assertEquals(2, testParameterList.size());

    }

    @Test
    public void getCategoryDtoList() {
        initMocks(this);

        when(categoryDao.getCategoryList()).thenReturn(getTestCategoryList());

        List<CategoryDto> testCategoryDtoList = categoryService.getCategoryDtoList();

        List<CategoryDto> exampleList = getTestCategoryList()
                .stream()
                .map(modelMapperWrapper::mapCategory)
                .collect(Collectors.toList());

        assertNotNull(testCategoryDtoList);
        assertEquals(exampleList,testCategoryDtoList);
    }

    @Test
    public void updateCategory() {
        initMocks(this);
        CategoryEntity category = new CategoryEntity();
        categoryService.updateCategory(category);

        verify(categoryDao).update(category);
    }

    @Test
    public void getGoodsListByFilter() {
        initMocks(this);

        CategoryEntity category = new CategoryEntity();
        when(categoryDao.getGoodsListByFilter(category,10, 100, "ASC")).thenReturn(getTestGoodsList());
        List<GoodsEntity> goodsList = categoryDao.getGoodsListByFilter(category,10,100, "ASC");

        assertNotNull(goodsList);
        assertEquals(goodsList,getTestGoodsList());
    }

    @Test
    public void getMaxPriceForCategory() {
        initMocks(this);
        CategoryEntity testCategory = new CategoryEntity();
        when(categoryDao.getMaxPriceForCategory(testCategory)).thenReturn(1000);

        int test = categoryService.getMaxPriceForCategory(testCategory);

        assertEquals(1000, test);

    }

    @Test
    public void findCategoryByName() {
        initMocks(this);

        when(categoryDao.findCategoryByName("name")).thenReturn(getTestCategory(100));

        CategoryEntity category = categoryService.findCategoryByName("name");

        assertNotNull(category);
        assertEquals(100, category.getId());
        assertEquals("name", category.getName());
    }

    @Test
    public void addCategory() {
        initMocks(this);

        CategoryEntity category = new CategoryEntity();
        categoryService.addCategory(category);

        verify(categoryDao).create(category);

    }

    @Test
    public void deleteCategoryById() {
        initMocks(this);

        categoryService.deleteCategoryById(100);

        verify(categoryDao).deleteCategoryById(100);
    }


    private CategoryEntity getTestCategory(int i) {
        CategoryEntity testCategory = new CategoryEntity();
        testCategory.setId(100);
        testCategory.setName("name");
        testCategory.setParameters(new ArrayList<ParameterEntity>());
        testCategory.setGoodsList(getTestGoodsList());
        return testCategory;
    }

    public List<GoodsEntity> getTestGoodsList() {
        GoodsEntity goods1 = new GoodsEntity();
        GoodsEntity goods2 = new GoodsEntity();
        List<GoodsEntity> testGoodsList = new ArrayList<>();
        testGoodsList.add(goods1);
        testGoodsList.add(goods2);
        return testGoodsList;
    }

    public List<CategoryEntity> getTestCategoryList() {
        CategoryEntity categoryEntity1 = new CategoryEntity();
        CategoryEntity categoryEntity2 = new CategoryEntity();
        List<CategoryEntity> testCategoryList = new ArrayList<>();
        testCategoryList.add(categoryEntity1);
        testCategoryList.add(categoryEntity2);
        return testCategoryList;
    }

    public List<ParameterEntity> getTestParameterList() {
        List<ParameterEntity> testParameterList = new ArrayList<>();
        testParameterList.add(new ParameterEntity());
        testParameterList.add(new ParameterEntity());
        return testParameterList;
    }


}