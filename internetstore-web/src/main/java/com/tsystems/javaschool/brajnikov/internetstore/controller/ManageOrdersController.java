package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.model.OrderEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller("manageOrdersController")
@RequestMapping
public class ManageOrdersController extends AbstractController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = {"/manageorders"}, method = RequestMethod.GET)
    public String showOrdersList(Model model){
        List<OrderEntity> orders = orderService.getAllOrders();
        model.addAttribute("loggedinuser", getPrincipal());
        model.addAttribute("orders",orders);

        return "/manageorders";
    }

}
