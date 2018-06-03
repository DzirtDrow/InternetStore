package com.tsystems.javaschool.brajnikov.internetstore.dto;

import lombok.Data;

@Data
public class GoodsParameterDto {

    private int id;
    private int numValue;
    private String stringValue;
    private GoodsDto goods;
    private ParameterDto parameter;
}
