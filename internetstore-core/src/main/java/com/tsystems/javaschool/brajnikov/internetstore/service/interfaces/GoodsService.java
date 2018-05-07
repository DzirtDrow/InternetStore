package com.tsystems.javaschool.brajnikov.internetstore.service.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;

import java.util.List;

public interface GoodsService {
    List<GoodsEntity> findAllGoods();

    void addGoods(GoodsEntity goodsEntity);
    void deleteGoods(GoodsEntity goodsEntity);

    void deleteGoodsById(Integer id);
}
