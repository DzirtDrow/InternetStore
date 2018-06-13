package com.tsystems.javaschool.brajnikov.internetstore.service.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dto.PromotionDto;
import com.tsystems.javaschool.brajnikov.internetstore.model.PromotionEntity;

import java.util.List;

public interface PromotionService {
     List<PromotionDto> getPromotionDtoList();
     List<PromotionEntity> getPromotionList();
}
