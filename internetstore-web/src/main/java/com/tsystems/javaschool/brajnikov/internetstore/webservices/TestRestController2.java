package com.tsystems.javaschool.brajnikov.internetstore.webservices;

import com.tsystems.javaschool.brajnikov.internetstore.dto.GoodsDto;
import com.tsystems.javaschool.brajnikov.internetstore.dto.PromotionDto;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.GoodsService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/rtest")
@Component
public class TestRestController2 {

    @Autowired
    PromotionService promotionService;

    @Autowired
    GoodsService goodsService;

    @GET
    @Path("/goods/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public GoodsDto getGoods(@PathParam("id") int id) {
        GoodsDto goods = new GoodsDto();
        goods.setId(id);
        goods.setName("Test Name");
        goods.setDescription("Test description");
        goods.setLeftCount(100);
        goods.setPrice(1000);
        //Response response = Response.ok(goods).build();
        return goods;
    }

//    @GET
//    @Path("/promotions")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<PromotionDto> getPromotions(){
//        List<PromotionDto> promoList = new ArrayList<PromotionDto>();
//        promoList.add(new PromotionDto(1,"test 1", "test desc 1"));
//        promoList.add(new PromotionDto(1,"test 2", "test desc 2"));
//        promoList.add(new PromotionDto(1,"test 3", "test desc 3"));
//        return promoList;
//    }

    @GET
    @Path("/promolist")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPromoList() {

       List<PromotionDto> promoList = new ArrayList<PromotionDto>();
  //     List<PromotionDto> promoList = promotionService.getPromotionDtoList();

        promoList.add(new PromotionDto(1, "test 1", "test desc 1"));
        promoList.add(new PromotionDto(2, "test 2", "test desc 2"));
        promoList.add(new PromotionDto(3,"test 3", "test desc 3"));
//        promoList.add(new PromotionDto(4,"test 4", "test desc 4"));
//        promoList.add(new PromotionDto(5,"test 5", "test desc 5"));
//        promoList.add(new PromotionDto(6,"test 6", "test desc 6"));
        return Response.ok(
               new GenericEntity<List<PromotionDto>>(promoList) {
                }).build();
    }

}
