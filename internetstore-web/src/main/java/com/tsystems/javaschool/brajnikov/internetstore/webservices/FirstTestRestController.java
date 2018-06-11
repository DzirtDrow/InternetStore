package com.tsystems.javaschool.brajnikov.internetstore.webservices;

import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FirstTestRestController {
    @Autowired
    private GoodsService goodsService;

    //-------------------Retrieve All Goods--------------------------------------------------------

    @RequestMapping(value = "/resttest/goods", method = RequestMethod.GET)
    public String listAllGoods() {
        List<GoodsEntity> goods = goodsService.findAllGoods();
        String result = goods.toString();
        return result;
    }
//
//    @RequestMapping(value = "/resttest/goods/{id}", method = RequestMethod.GET)
//    public String goodsShow(@PathVariable("id") int id) {
//
//        String result = goodsService.findGoodsById(id).toString();
//        return result;
//    }
//    @RequestMapping(value = "/resttest/goodslist/", method = RequestMethod.GET)
//    public ResponseEntity<List<GoodsEntity>> listAllGoods2() {
//        List<GoodsEntity> goods = goodsService.findAllGoods();
//        if(goods.isEmpty()){
//            return new ResponseEntity<List<GoodsEntity>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<GoodsEntity>>(goods, HttpStatus.OK);
//    }
//
//
//    @RequestMapping(value = "/resttest/goods2/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<GoodsEntity> getGoods(@PathVariable("id") int id) {
//        GoodsEntity goods = goodsService.findGoodsById(id);
//        if (goods == null) {
//            return new ResponseEntity<GoodsEntity>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity(goods, HttpStatus.OK);
//    }
//
//    @RequestMapping("/resttest")
//    public String welcome() {//Welcome page, non-rest
//        return "Welcome to First RestTemplate Example.";
//    }
//    @RequestMapping(value = "/resttest/goods3/{id}",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public GoodsDto getGoods3(@PathVariable("id") int id) {
//        GoodsDto goods = new GoodsDto();
//        goods.setId(id);
//        goods.setName("Test Name");
//        goods.setDescription("Test description");
//        goods.setLeftCount(100);
//        goods.setPrice(1000);
//
//        return goods;
//    }


}