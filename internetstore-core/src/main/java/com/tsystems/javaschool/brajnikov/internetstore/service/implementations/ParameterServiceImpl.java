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
}
