package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.GoodsParameterDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsParameterEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.GoodsParameterService;
import com.tsystems.javaschool.brajnikov.internetstore.enums.ParameterTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("goodsParameterService")
public class GoodsParameterServiceImpl implements GoodsParameterService {
    @Autowired
    private GoodsParameterDao goodsParameterDao;

    @Override
    @Transactional
    public void updateGoodsParameter(GoodsParameterEntity goodsParameterEntity) {
        GoodsParameterEntity param = goodsParameterDao.read(goodsParameterEntity.getId());
        if(param.getParameter().getParameterType() == ParameterTypeEnum.param_num){
            param.setNumValue(goodsParameterEntity.getNumValue());
        } else {
            param.setStringValue(goodsParameterEntity.getStringValue());
        }
        goodsParameterDao.update(param);
    }
}
