package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.exception.OrdersNotFoundException;
import com.tsystems.javaschool.brajnikov.internetstore.model.OrderEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.PersistentLogin;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.OrderService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller("orderController")
@RequestMapping
public class OrderController extends AbstractController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/order"}, method = RequestMethod.GET)
    public String listGoods(Model model) {
        if (!isCurrentAuthenticationAnonymous()) {
            model.addAttribute("loggedinuser", "anonymousUser");

            UserEntity user = userService.findByName(getPrincipal()); //TODO make DTO!

//            int orderId = orderService.createOrderByCart(user.getCart());


            return "/order";
        } else {
            model.addAttribute("loggedinuser", getPrincipal());
            return "/login";
        }
    }


    @RequestMapping(value = {"/orders-list"}, method = RequestMethod.GET)
    public String listUserOrders(Model model) {

        if (!isCurrentAuthenticationAnonymous()) {
            model.addAttribute("loggedinuser", getPrincipal());

            UserEntity user = userService.findByName(getPrincipal()); //TODO make DTO!
            try {
                List<OrderEntity> userOrders = orderService.getOrdersListByUser(user);//orderService.getOrdersListByUser(user.getId());
                model.addAttribute("orders", userOrders);
            } catch (OrdersNotFoundException ex) {
                return "/index"; //TODO to error list
            }
            return "/orders-list";
        } else {
            model.addAttribute("loggedinuser", getPrincipal());
            return "/login";
        }

    }

}
