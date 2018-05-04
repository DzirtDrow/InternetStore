package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.GoodsService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller("appController")
@RequestMapping("/")
public class AppController {

    @Autowired
    UserService userService;

    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(ModelMap model) {
        return "index";
    }


    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        List<UserEntity> users = userService.findAllUsers();
        model.addAttribute("users", users);
        //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!" + users);
        return "list";
    }

    @RequestMapping(value = {"/goodslist"}, method = RequestMethod.GET)
    public String listGoods(ModelMap model) {
        List<GoodsEntity> goods = goodsService.findAllGoods();
        model.addAttribute("goods", goods);
        //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!" + users);
        return "goodslist";
    }

}
