package com.tsystems.javaschool.brajnikov.internetstore.webservice;

import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/resttest1")
    public String welcome() {//Welcome page, non-rest
//        goodsService.findGoodsById(1);

        return "Welcome to RestTemplate Example.";
    }
}
