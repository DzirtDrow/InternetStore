package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.model.CartItemEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.OrderEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.OrderService;
import com.tsystems.javaschool.brajnikov.internetstore.util.OrderStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller("manageOrdersController")
@RequestMapping
public class ManageOrdersController extends AbstractController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = {"/manageorders"}, method = RequestMethod.GET)
    public String showOrdersList(Model model) {
        List<OrderEntity> orders = orderService.getAllOrders();
        model.addAttribute("loggedinuser", getPrincipal());
        model.addAttribute("orders", orders);

        return "/manageorders";
    }

    @RequestMapping(value = {"/manageoneorder"}, method = RequestMethod.GET)
    public String showManageOrder(Model model, @RequestParam("id") Integer orderId) {
        OrderEntity order = orderService.getOrderById(orderId);
        model.addAttribute("loggedinuser", getPrincipal());

        //List<OrderStatusEnum> list = Arrays.asList(OrderStatusEnum.values());
        model.addAttribute("orderStatuses", OrderStatusEnum.values());

        model.addAttribute("orderStatus", order.getStatus());

        model.addAttribute("order", order);
        List<CartItemEntity> items = orderService.getOrderById(orderId).getOrderItems();
        model.addAttribute("items", items);

        return "/manageoneorder";
    }

    @RequestMapping(value = {"/manageoneorder"}, method = RequestMethod.POST)
    public String saveOrder(Model model, @ModelAttribute("order") OrderEntity orderEntity) {

        orderService.updateOrder(orderEntity);
        return "/manageoneorder?id=" + orderEntity.getId();
    }

    @RequestMapping(value = {"/changeorderstatus"}, method = RequestMethod.GET)
    public String changeOrderStatus(Model model, @RequestParam("id") Integer orderId) {

        orderService.pushOrderStatus(orderService.getOrderById(orderId));
        return "redirect:/manageoneorder?id=" + orderId;
    }

}
