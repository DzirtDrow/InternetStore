package com.tsystems.javaschool.brajnikov.internetstore.filter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PriceFilter {
    private Integer min;
    private Integer max;

    public PriceFilter(){
        min = 0;
        max = 0;
    }

}
