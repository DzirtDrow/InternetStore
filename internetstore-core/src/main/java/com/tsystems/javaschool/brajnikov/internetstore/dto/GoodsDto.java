package com.tsystems.javaschool.brajnikov.internetstore.dto;

import lombok.Data;

import java.util.List;

@Data
public class GoodsDto {
    private int id;
    private String name;
    private Integer price;
    private String description;
    private int leftCount;
    private CategoryDto category;
    private List<GoodsParameterDto> goodsParameterList;
}
