package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.PromotionDao;
import com.tsystems.javaschool.brajnikov.internetstore.dto.PromotionDto;
import com.tsystems.javaschool.brajnikov.internetstore.model.PromotionEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.PromotionService;
import com.tsystems.javaschool.brajnikov.internetstore.util.ModelMapperWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("promotionService")
@Transactional
public class PromotionServiceImpl implements PromotionService {
    @Autowired
    private PromotionDao promotionDao;

    @Autowired
    ModelMapperWrapper modelMapperWrapper;


    public List<PromotionDto> getPromotionDtoList() {
        List<PromotionDto> result;// = new ArrayList<>();


        result = promotionDao.getPromotionList()
                .stream()
                .map(modelMapperWrapper::mapPromotion)
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public List<PromotionEntity> getPromotionList() {
        return promotionDao.getList();
    }

    @Override
    public PromotionEntity getPromotionById(Integer id) {
        return promotionDao.read(id);
    }

    @Override
    public void updatePromotion(PromotionEntity promo) {
        promotionDao.update(promo);
    }

    @Override
    public void createPromotion(PromotionEntity promo) {
        promotionDao.create(promo);
    }

    @Override
    public void deletePromotionById(Integer id) {
        promotionDao.delete(promotionDao.read(id));
    }
}
