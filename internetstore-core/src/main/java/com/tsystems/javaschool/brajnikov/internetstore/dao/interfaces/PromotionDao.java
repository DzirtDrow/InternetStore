package com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dao.GenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.PromotionEntity;

import java.util.List;

public interface PromotionDao extends GenericDao<PromotionEntity, Integer> {
    List<PromotionEntity> getPromotionList();
}
