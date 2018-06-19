package com.tsystems.javaschool.brajnikov.internetstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionDto {
    int id;
    String name;
    String description;
}
