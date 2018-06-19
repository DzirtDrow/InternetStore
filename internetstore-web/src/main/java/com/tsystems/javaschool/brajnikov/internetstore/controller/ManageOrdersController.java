package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.model.CartItemEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.OrderEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.OrderService;
import com.tsystems.javaschool.brajnikov.internetstore.enums.OrderStatusEnum;
import com.tsystems.javaschool.brajnikov.internetstore.enums.SortingTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * The Manage orders controller for managers.
 */
@Controller("manageOrdersController")
@RequestMapping
public class ManageOrdersController extends AbstractController {

    @Autowired
    private OrderService orderService;

    /**
     * The Logger.
     */
    static final Logger logger = LoggerFactory.getLogger(ManageOrdersController.class);

    /**
     * Show orders list.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = {"/manageorders","/manageorders/{type}"}, method = RequestMethod.GET)
    public String showOrdersList(@PathVariable Map<String, String> pathVariablesMap, Model model) {

        String type = pathVariablesMap.get("type");
        List<OrderEntity> orders = null;
        if (type == null){
            orders = orderService.getAllOrders();
        } else if(type.equals("orderbydateasc")){
            orders = orderService.getAllOrdersOrderByDate(SortingTypeEnum.ASC);
        } else if(type.equals("orderbydatedesc")){
            orders = orderService.getAllOrdersOrderByDate(SortingTypeEnum.DESC);
        } else if(type.equals("orderbystatusasc")){
            orders = orderService.getAllOrdersOrderByStatus(SortingTypeEnum.ASC);
        } else if(type.equals("orderbystatusdesc")){
            orders = orderService.getAllOrdersOrderByStatus(SortingTypeEnum.DESC);
        }

        //List<OrderEntity> orders = orderService.getAllOrders();
        model.addAttribute("loggedinuser", getPrincipal());
        model.addAttribute("orders", orders);
        logger.info("Showing manage oreders page");
        return "/manageorders";
    }

    /**
     * Show manage order page.
     *
     * @param model   the model
     * @param orderId the order id
     * @return the string
     */
    @RequestMapping(value = {"/manageoneorder"}, method = RequestMethod.GET)
    public String showManageOrder(Model model, @RequestParam("id") Integer orderId) {
        OrderEntity order = orderService.getOrderById(orderId);
        model.addAttribute("orderStatuses", OrderStatusEnum.values());
        model.addAttribute("orderStatus", order.getStatus());
        model.addAttribute("order", order);
        List<CartItemEntity> items = orderService.getOrderById(orderId).getOrderItems();
        model.addAttribute("items", items);

        logger.info("Showing manage one order page for order {}", orderId);

        return "/manageoneorder";
    }

    /**
     * Save order.
     *
     * @param model       the model
     * @param orderEntity the {@link OrderEntity}
     * @return the string
     */
    @RequestMapping(value = {"/manageoneorder"}, method = RequestMethod.POST)
    public String saveOrder(Model model, @ModelAttribute("order") OrderEntity orderEntity) {

        orderService.updateOrder(orderEntity);
        logger.info("Save managed order {}", orderEntity.getId());
        return "/manageoneorder?id=" + orderEntity.getId();
    }

    /**
     * Change order status.
     *
     * @param model   the model
     * @param orderId the order id
     * @return the string
     */
    @RequestMapping(value = {"/changeorderstatus"}, method = RequestMethod.GET)
    public String changeOrderStatus(Model model, @RequestParam("id") Integer orderId) {

        orderService.pushOrderStatus(orderService.getOrderById(orderId));
        logger.info("Changing order {} status to {}", orderId, orderService.getOrderById(orderId).getStatus());
        return "redirect:/manageoneorder?id=" + orderId;
    }

}
