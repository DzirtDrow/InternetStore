package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.GoodsDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


public class GoodsServiceImplTest {

    @InjectMocks
    private GoodsServiceImpl goodsService;
    @Mock
    private GoodsDao goodsDao;

    @Test
    public void findGoodsById() {
        initMocks(this);
        when(goodsDao.read(100)).thenReturn(getTestGoods());

        GoodsEntity goodsEntity = goodsService.findGoodsById(100);

        assertNotNull(goodsEntity);
        assertEquals("test", goodsEntity.getName());
        assertEquals("test test", goodsEntity.getDescription());
        assertEquals(100, goodsEntity.getId());
        assertEquals(new Integer(200), goodsEntity.getPrice());
        assertEquals(300, goodsEntity.getLeftCount());

    }

    @Test
    public void findAllGoods() {
        initMocks(this);
        List<GoodsEntity> goodsList = new ArrayList<GoodsEntity>();
        goodsList.add(getTestGoods());
        goodsList.add(getTestGoods());
        goodsList.add(getTestGoods());

        when(goodsDao.findAllGoods()).thenReturn(goodsList);

        List<GoodsEntity> resultGoodsList =  goodsService.findAllGoods();
        assertNotNull(resultGoodsList);
        assertTrue(!resultGoodsList.isEmpty());
        assertEquals(3, resultGoodsList.size());
        assertEquals(getTestGoods(), resultGoodsList.get(1));

    }

    @Test
    public void deleteGoods() {
    }

    @Test
    public void updateGoods() {
    }

    @Test
    public void deleteGoodsById() {
    }


    private GoodsEntity getTestGoods() {
        GoodsEntity goods = new GoodsEntity();
        goods.setName("test");
        goods.setPrice(200);
        goods.setId(100);
        goods.setDescription("test test");
        goods.setLeftCount(300);
        return goods;
    }
}