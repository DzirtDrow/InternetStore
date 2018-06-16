package com.tsystems.javaschool.brajnikov.internetstore.service.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.model.ParameterEntity;

import java.util.List;

public interface ParameterService  {
    List<ParameterEntity> getPossibleParameters();

    ParameterEntity getParameterById(Integer idparam);
}
