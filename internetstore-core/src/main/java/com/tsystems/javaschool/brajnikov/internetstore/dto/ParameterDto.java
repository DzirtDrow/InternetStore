package com.tsystems.javaschool.brajnikov.internetstore.dto;

import com.tsystems.javaschool.brajnikov.internetstore.util.ParameterTypeEnum;
import lombok.Data;

@Data
public class ParameterDto {
    private int id;
    private String name;
    private String description;
    private ParameterTypeEnum parameterType;
}
