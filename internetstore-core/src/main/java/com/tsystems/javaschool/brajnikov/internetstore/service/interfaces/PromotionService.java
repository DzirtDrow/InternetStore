package com.tsystems.javaschool.brajnikov.internetstore.service.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dto.PromotionDto;
import com.tsystems.javaschool.brajnikov.internetstore.model.PromotionEntity;

import java.util.List;

public interface PromotionService {
     List<PromotionDto> getPromotionDtoList();
     List<PromotionEntity> getPromotionList();

    PromotionEntity getPromotionById(Integer id);

    void updatePromotion(PromotionEntity promo);

    void createPromotion(PromotionEntity promo);

    void deletePromotionById(Integer id);
}
