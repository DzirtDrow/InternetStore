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
//        Random r = new Random();
//        for(int i = 0; i < r.nextInt(6) + 2; i++){
//            result.add(new PromotionDto(i, "test" + i, "test desc" + i));
//        }

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
}
