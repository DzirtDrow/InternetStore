package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.exception.CartIsEmptyException;
import com.tsystems.javaschool.brajnikov.internetstore.exception.OrdersNotFoundException;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.OrderEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.implementations.CustomAuthentificationSuccessHandler;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.CartService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.OrderService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.UserService;
import com.tsystems.javaschool.brajnikov.internetstore.util.OrderStatusEnum;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

//    @RequestMapping(value = {"/order"}, method = RequestMethod.GET)
//    public String showOrder(Model model) {
//        if (!isCurrentAuthenticationAnonymous()) {
//            model.addAttribute("loggedinuser", "anonymousUser");
//            //model.addAttribute("userRole", getLoggedInUserEntity().getRole().toString());
//            UserEntity user = userService.findByName(getPrincipal()); //TODO make DTO!
//
////            int orderId = orderService.createOrderByCart(user.getCart());
//
//            return "/order";
//        } else {
//            model.addAttribute("loggedinuser", getPrincipal());
//            return "/login";
//        }
//    }

    @RequestMapping(value = {"/order"}, method = RequestMethod.GET)
    public String showOneOrder(Model model, @RequestParam("id") Integer orderId) {
        if (!isCurrentAuthenticationAnonymous()) {
            UserEntity user = userService.findByName(getPrincipal());
            model.addAttribute("loggedinuser", getPrincipal());
            OrderEntity order = orderService.getOrderById(orderId);
            if (order.getUser().getId() == user.getId()) {
                model.addAttribute("order", order);
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
            UserEntity user = userService.findByName(getPrincipal());
            model.addAttribute("loggedinuser", getPrincipal());
            OrderEntity order = orderService.getOrderById(orderId);
            order.setStatus(OrderStatusEnum.PENDING_SHIPPING);
            orderService.updateOrder(order);
        }
        return "redirect:/order?id=" + orderId;
    }
//    @RequestMapping(value = "/order", method = RequestMethod.POST)
//    public ModelAndView updateOrder(@ModelAttribute("order") OrderEntity orderEntity, Model model) {
//        //orderEntity.setStatus(OrderStatusEnum.PENDING_SHIPPING);
//
//        //orderService.updateOrder(orderEntity);
//        return new ModelAndView("/order?id="+7);
//    }

    @RequestMapping(value = {"/orders-list"}, method = RequestMethod.GET)
    public String listUserOrders(Model model) {

        if (!isCurrentAuthenticationAnonymous()) {
            model.addAttribute("loggedinuser", getPrincipal());
            //model.addAttribute("userRole", getLoggedInUserEntity().getRole().toString());

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

    @RequestMapping(value = "/createorderfromcart", method = RequestMethod.GET)
    public String createOrderFromCart(Model model) {
        if (!isCurrentAuthenticationAnonymous()) {
            UserEntity user = userService.findByName(getPrincipal());
            CartEntity cart = cartService.getCartByUser(user);
            try {
                orderService.createOrderByCart(cart);
            } catch (CartIsEmptyException e) {
                return "/cart";
            }
        } else {
            authHandler.setOrderFlag(true);
            return "/login";
            //TODO create order from session cart with login
        }
        return "/order";
    }
}
