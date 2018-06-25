package com.tsystems.javaschool.brajnikov.internetstore.filter;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The type Price filter.
 */
@Data
@AllArgsConstructor
public class PriceFilter {
    private Integer min;
    private Integer max;

    /**
     * Instantiates a new Price filter.
     */
    public PriceFilter(){
        min = 0;
        max = 0;
    }

}
