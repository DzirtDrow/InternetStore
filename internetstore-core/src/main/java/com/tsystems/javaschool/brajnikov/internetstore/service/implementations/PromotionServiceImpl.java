package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.PromotionDao;
import com.tsystems.javaschool.brajnikov.internetstore.dto.PromotionDto;
import com.tsystems.javaschool.brajnikov.internetstore.model.PromotionEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.PromotionService;
import com.tsystems.javaschool.brajnikov.internetstore.util.ModelMapperWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("promotionService")
@Transactional
public class PromotionServiceImpl implements PromotionService {
    @Autowired
    private PromotionDao promotionDao;

    @Autowired
    ModelMapperWrapper modelMapperWrapper;


    public List<PromotionDto> getPromotionDtoList() {
        List<PromotionDto> result = new ArrayList<>();
        result.add(new PromotionDto(1, "test 1", "test desc 12312341"));
        result.add(new PromotionDto(2, "test 2", "test desc 2"));
//                promotionDao.getList()
//                .stream()
//                .map(modelMapperWrapper::mapPromotion)
//                .collect(Collectors.toList());
        return result;
    }

    @Override
    public List<PromotionEntity> getPromotionList() {
        return promotionDao.getList();
    }
}
