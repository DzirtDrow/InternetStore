package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.GoodsParameterDao;
import com.tsystems.javaschool.brajnikov.internetstore.enums.ParameterTypeEnum;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsParameterEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.ParameterEntity;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class GoodsParameterServiceImplTest {
    @Mock
    private GoodsParameterDao goodsParameterDao;
    @InjectMocks
    private GoodsParameterServiceImpl goodsParameterService;
    @Test
    public void updateGoodsParameter() {
        initMocks(this);

        GoodsParameterEntity goodsParameterEntity = new GoodsParameterEntity();
        goodsParameterEntity.setId(100);
        goodsParameterEntity.setNumValue(100);

        ParameterEntity param = new ParameterEntity();
        param.setParameterType(ParameterTypeEnum.param_num);
        goodsParameterEntity.setParameter(param);

        when(goodsParameterDao.read(goodsParameterEntity.getId())).thenReturn(goodsParameterEntity);

        goodsParameterService.updateGoodsParameter(goodsParameterEntity);

        verify(goodsParameterDao).update(goodsParameterEntity);

    }
}