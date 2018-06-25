package com.tsystems.javaschool.brajnikov.internetstore.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Parameter type enum.
 */
@AllArgsConstructor
public enum ParameterTypeEnum {
    /**
     * Param num parameter type enum.
     */
    param_num("param_num"), /**
     * Param string parameter type enum.
     */
    param_string("param_string");

    @Getter
    private String description;
}
