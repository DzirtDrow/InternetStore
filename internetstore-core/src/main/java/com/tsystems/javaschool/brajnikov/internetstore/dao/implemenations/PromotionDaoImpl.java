package com.tsystems.javaschool.brajnikov.internetstore.dao.implemenations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.AbstractGenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.PromotionDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.PromotionEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PromotionDaoImpl extends AbstractGenericDao<PromotionEntity, Integer> implements PromotionDao {
}
