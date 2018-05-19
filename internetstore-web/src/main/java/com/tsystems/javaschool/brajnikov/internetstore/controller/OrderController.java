package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.OrderService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("orderController")
@RequestMapping("/order")
public class OrderController extends AbstractController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/order"}, method = RequestMethod.GET)
    public String listGoods(Model model) {
        if (isCurrentAuthenticationAnonymous()) {
            model.addAttribute("loggedinuser", "anonymousUser");

            UserEntity user = userService.findByName(getPrincipal()); //TODO make DTO!

//            int orderId = orderService.createOrderByCart(user.getCart());


            return "/order";
        } else {
            model.addAttribute("loggedinuser", getPrincipal());
            return "/login";
        }
    }

}
