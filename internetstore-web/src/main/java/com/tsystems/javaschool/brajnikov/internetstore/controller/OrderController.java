package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.exception.CartIsEmptyException;
import com.tsystems.javaschool.brajnikov.internetstore.exception.OrdersNotFoundException;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartItemEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.OrderEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.implementations.CustomAuthentificationSuccessHandler;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.CartService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.OrderService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller("orderController")
@RequestMapping
public class OrderController extends AbstractController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomAuthentificationSuccessHandler authHandler;

    static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @RequestMapping(value = {"/order"}, method = RequestMethod.GET)
    public String showOneOrder(Model model, @RequestParam("id") Integer orderId) {
        if (!isCurrentAuthenticationAnonymous()) {
            UserEntity user = userService.findByName(getPrincipal());
            model.addAttribute("loggedinuser", getPrincipal());
            OrderEntity order = orderService.getOrderById(orderId);

            List<CartItemEntity> items = orderService.getOrderById(orderId).getOrderItems();

            if (order.getUser().getId() == user.getId()) {
                model.addAttribute("order", order);
                model.addAttribute("items", items);
            } else {
                return "/accessdenied";
            }
        } else {
            return "/accessdenied";
        }
        return "/order";
    }
    @RequestMapping(value = "/orderPay", method = RequestMethod.GET)
    public String orderPay(Model model,@RequestParam("id") Integer orderId){
        if (!isCurrentAuthenticationAnonymous()) {
            model.addAttribute("loggedinuser", getPrincipal());

            OrderEntity order = orderService.getOrderById(orderId);
            orderService.pushOrderStatus(order);
        }
        return "redirect:/order?id=" + orderId;
    }

    @RequestMapping(value = {"/orders-list"}, method = RequestMethod.GET)
    public String listUserOrders(Model model) {

        if (!isCurrentAuthenticationAnonymous()) {
            model.addAttribute("loggedinuser", getPrincipal());

            UserEntity user = userService.findByName(getPrincipal());
            try {
                List<OrderEntity> userOrders = orderService.getOrdersListByUser(user);
                model.addAttribute("orders", userOrders);
            } catch (OrdersNotFoundException ex) {
                return "/index";
            }
            return "/orders-list";
        } else {
            model.addAttribute("loggedinuser", getPrincipal());
            return "/login";
        }

    }

    @RequestMapping(value = "/createorderfromcart", method = RequestMethod.GET)
    public String createOrderFromCart(Model model) {
        int id;
        if (!isCurrentAuthenticationAnonymous()) {
            UserEntity user = userService.findByName(getPrincipal());
            CartEntity cart = cartService.getCartByUser(user);

            try {
                 id = orderService.createOrderByCart(cart);

            } catch (CartIsEmptyException e) {
                return "/cart";
            }
        } else {
            authHandler.setOrderFlag(true);
            return "/login";
            //TODO create order from session cart with login
        }
        return "redirect:/order?id="+id;
    }
}
