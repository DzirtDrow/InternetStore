package com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dao.GenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.ParameterEntity;

/**
 * The interface Parameter dao.
 */
public interface ParameterDao extends GenericDao<ParameterEntity, Integer> {

    /**
     * Find by name parameter entity.
     *
     * @param name the name
     * @return the parameter entity
     */
    ParameterEntity findByName(String name);
}
