package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.dto.SessionCart;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.OrderEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.GoodsService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller("storeController")
@SessionAttributes("order")
public class StoreController extends AbstractController {

    @Autowired
    UserService userService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    SessionCart sessionCart;

//    @Autowired
//    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
//
//    @Autowired
//    AuthenticationTrustResolver authenticationTrustResolver;

    @RequestMapping(value = {"/store"}, method = RequestMethod.GET)
    public String storeList(Model model) {
        List<GoodsEntity> goods = goodsService.findAllGoods();

        model.addAttribute("loggedinuser", getPrincipal());

        model.addAttribute("goods", goods);
        OrderEntity order = new OrderEntity();

        model.addAttribute("order", order);
        return "/store";
    }

    @RequestMapping(value = "/addtocart")
    public String deleteGoods(Model model, @RequestParam("id") String id) {
        if (id != null) {

        }


        return "redirect:/store";
    }
}
