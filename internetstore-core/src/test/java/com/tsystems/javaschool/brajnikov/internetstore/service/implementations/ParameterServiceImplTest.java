package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.ParameterDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.ParameterEntity;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ParameterServiceImplTest {

    @Mock
    private ParameterDao parameterDao;
    @InjectMocks
    private ParameterServiceImpl parameterService;

    @Test
    public void getPossibleParameters() {
        initMocks(this);

        when(parameterDao.getList()).thenReturn(getTestParameterList());

        List<ParameterEntity> parameterList = parameterService.getPossibleParameters();

        assertNotNull(parameterList);
        assertEquals(getTestParameterList(), parameterList);
    }

    @Test
    public void getParameterById() {
        initMocks(this);

        when(parameterDao.read(100)).thenReturn(getTestParameter(100));

        ParameterEntity parameter = parameterService.getParameterById(100);

        assertNotNull(parameter);
        assertEquals(getTestParameter(100), parameter);

    }


    @Test
    public void addNewParameter() {
    }

    private ParameterEntity getTestParameter(int i) {
        ParameterEntity parameterEntity = new ParameterEntity();
        parameterEntity.setId(i);
        return parameterEntity;
    }
    public List<ParameterEntity> getTestParameterList() {

        List<ParameterEntity> testParameterList = new ArrayList<>();
        testParameterList.add(getTestParameter(100));
        testParameterList.add(getTestParameter(200));
        return testParameterList;
    }
}