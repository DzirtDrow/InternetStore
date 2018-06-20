package com.tsystems.javaschool.brajnikov.internetstore.webservices;

import com.tsystems.javaschool.brajnikov.internetstore.dto.GoodsDto;
import com.tsystems.javaschool.brajnikov.internetstore.dto.PromotionDto;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.GoodsService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestRestController3 {
    @Autowired
    private PromotionService promotionService;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/topgoods", produces = "application/json")
    public List<GoodsDto> getGoods() {
        List<GoodsDto> topSales = goodsService.getTopSales(10);
        //Response response = Response.ok(goods).build();
        return topSales;
    }

    @GetMapping(value="/promo", produces = "application/json")
    public List<PromotionDto> getPromoList() {

        List<PromotionDto> promoList = promotionService.getPromotionDtoList();

        return promoList;
    }
}
