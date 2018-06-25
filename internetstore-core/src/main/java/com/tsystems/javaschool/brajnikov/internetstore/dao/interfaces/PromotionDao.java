package com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dao.GenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.PromotionEntity;

import java.util.List;

/**
 * The interface Promotion dao.
 */
public interface PromotionDao extends GenericDao<PromotionEntity, Integer> {
    /**
     * Gets promotion list.
     *
     * @return the promotion list
     */
    List<PromotionEntity> getPromotionList();
}
