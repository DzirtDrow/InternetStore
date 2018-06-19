package com.tsystems.javaschool.brajnikov.internetstore.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ParameterTypeEnum {
    param_num("param_num"), param_string("param_string");

    @Getter
    private String description;
}
