package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.ParameterDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.ParameterEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("parameterService")
public class ParameterServiceImpl implements ParameterService {
    @Autowired
    private ParameterDao parameterDao;

    @Override
    @Transactional
    public List<ParameterEntity> getPossibleParameters() {
        return parameterDao.getList();
    }

    @Override
    @Transactional
    public ParameterEntity getParameterById(Integer idparam) {
        return parameterDao.read(idparam);
    }

    @Override
    @Transactional
    public Integer addNewParameter(ParameterEntity parameterEntity) {
        if (parameterDao.findByName(parameterEntity.getName()) == null) {
            return parameterDao.create(parameterEntity);
        }
        return null;
    }
}
