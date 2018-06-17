package com.tsystems.javaschool.brajnikov.internetstore.webservices;

import com.tsystems.javaschool.brajnikov.internetstore.dto.PromotionDto;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestRestController3 {
    @Autowired
    private PromotionService promotionService;
    @GetMapping(value="/promo", produces = "application/json")
    public Response getPromoList() {

        List<PromotionDto> promoList = new ArrayList<PromotionDto>();
       // List<PromotionDto> promoList = promotionService.getPromotionDtoList();

        promoList.add(new PromotionDto(1, "test 1", "test desc 1"));
        promoList.add(new PromotionDto(2, "test 2", "test desc 2"));
//        promoList.add(new PromotionDto(3,"test 3", "test desc 3"));
//        promoList.add(new PromotionDto(4,"test 4", "test desc 4"));
//        promoList.add(new PromotionDto(5,"test 5", "test desc 5"));
//        promoList.add(new PromotionDto(6,"test 6", "test desc 6"));

        promoList = promotionService.getPromotionDtoList();

        return Response.ok(
                new GenericEntity<List<PromotionDto>>(promoList) {
                }).build();
    }
}
