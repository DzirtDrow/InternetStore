package com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractGenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.GenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;

import java.util.List;

public interface GoodsDao extends GenericDao<GoodsEntity, Integer> {

    List<GoodsEntity> findAllGoods();

}
