package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.GoodsDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("goodsService")
@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao dao;

    public List<GoodsEntity> findAllGoods() {
        return dao.findAllGoods();
    }

    public void addGoods(GoodsEntity goodsEntity) {
        dao.create(goodsEntity);
    }

    public void deleteGoods(GoodsEntity goodsEntity) {
        dao.delete(goodsEntity);
    }

    public GoodsEntity findGoodsById(int id) {
        return dao.read(id);
    }

    public void updateGoods(GoodsEntity goodsEntity) {
        dao.update(goodsEntity);
    }

    public void deleteGoodsById(Integer id) {
        dao.delete(dao.read(id));
    }
}
