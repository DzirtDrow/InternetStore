package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.PromotionDao;
import com.tsystems.javaschool.brajnikov.internetstore.dto.PromotionDto;
import com.tsystems.javaschool.brajnikov.internetstore.model.PromotionEntity;
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

public class PromotionServiceImplTest {

    @InjectMocks
    private PromotionServiceImpl promotionService;
    @Mock
    private PromotionDao promotionDao;

    @Mock
    @Autowired
    ModelMapperWrapper modelMapperWrapper;

    @Test
    public void getPromotionDtoList() {
        initMocks(this);

        when(promotionDao.getPromotionList()).thenReturn(getTestPromotionList());

        List<PromotionDto> testPromotionDtoList = promotionService.getPromotionDtoList();

        assertNotNull(testPromotionDtoList);

        List<PromotionDto> pdl = getTestPromotionList()
                .stream()
                .map(modelMapperWrapper::mapPromotion)
                .collect(Collectors.toList());

        assertEquals(pdl, testPromotionDtoList);

    }

    @Test
    public void getPromotionList() {
        initMocks(this);

        when(promotionDao.getList()).thenReturn(getTestPromotionList());

        List<PromotionEntity> testPromotionList = promotionService.getPromotionList();

        assertNotNull(testPromotionList);
        assertEquals(getTestPromotionList(), testPromotionList);
    }

    @Test
    public void getPromotionById() {
        initMocks(this);

        when(promotionDao.read(100)).thenReturn(getTestPromotion(100));

        PromotionEntity promo = promotionService.getPromotionById(100);

        assertNotNull(promo);
        assertEquals(100, promo.getId());
    }

    @Test
    public void updatePromotion() {
        initMocks(this);
        PromotionEntity promo = new PromotionEntity();

        promotionService.updatePromotion(promo);
        verify(promotionDao).update(promo);
    }

    @Test
    public void createPromotion() {
        initMocks(this);
        PromotionEntity promo = new PromotionEntity();

        promotionService.createPromotion(promo);
        verify(promotionDao).create(promo);
    }

    @Test
    public void deletePromotionById() {
        initMocks(this);
        PromotionEntity promo = new PromotionEntity();
        promo.setId(100);

        when(promotionDao.read(100)).thenReturn(promo);
        promotionService.deletePromotionById(100);
        verify(promotionDao).delete(promo);
    }

    public List<PromotionEntity> getTestPromotionList() {
        PromotionEntity testPromotion1 = new PromotionEntity();
        testPromotion1.setId(100);
        testPromotion1.setName("100");
        testPromotion1.setDescription("description");
        PromotionEntity testPromotion2 = new PromotionEntity();
        testPromotion2.setId(200);
        testPromotion2.setName("200");
        testPromotion2.setDescription("description");

        List<PromotionEntity> testPromotionList = new ArrayList<>();
        testPromotionList.add(testPromotion1);
        testPromotionList.add(testPromotion2);

        return testPromotionList;
    }

    public PromotionEntity getTestPromotion(int i) {
        PromotionEntity testPromotion = new PromotionEntity();
        testPromotion.setId(i);
        testPromotion.setName("100");
        testPromotion.setDescription("description");
        return testPromotion;
    }
}