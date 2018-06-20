package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.dto.SessionCart;
import com.tsystems.javaschool.brajnikov.internetstore.enums.OrderDeliveryTypeEnum;
import com.tsystems.javaschool.brajnikov.internetstore.enums.OrderPaymentMethodEnum;
import com.tsystems.javaschool.brajnikov.internetstore.enums.OrderStatusEnum;
import com.tsystems.javaschool.brajnikov.internetstore.exception.CartIsEmptyException;
import com.tsystems.javaschool.brajnikov.internetstore.exception.NoGoodsInStockException;
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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * The Order controller.
 */
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
    private SessionCart sessionCart;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    private CustomAuthentificationSuccessHandler authHandler;

    /**
     * The Logger.
     */
    static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    /**
     * Show one order.
     *
     * @param model   the model
     * @param orderId the order id
     * @return the string
     */
    @RequestMapping(value = {"/order"}, method = RequestMethod.GET)
    public String showOneOrder(Model model, @RequestParam("id") Integer orderId) {
        if (!isCurrentAuthenticationAnonymous()) {
            UserEntity user = userService.findByName(getPrincipal());
            model.addAttribute(LOGGED_IN_USER_ATTRIBUTE_NAME, getPrincipal());
            OrderEntity order = orderService.getOrderById(orderId);

            List<CartItemEntity> items = orderService.getOrderById(orderId).getOrderItems();

            model.addAttribute("deliverytypes", OrderDeliveryTypeEnum.values());
            model.addAttribute("paymentmethods", OrderPaymentMethodEnum.values());
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

    @RequestMapping(value = {"/order"}, method = RequestMethod.POST)
    public String continueOrder(Model model, @ModelAttribute("order") OrderEntity order) {
        OrderEntity oldOrder = orderService.getOrderById(order.getId());
        oldOrder.setPaymentMethod(order.getPaymentMethod());
        oldOrder.setDeliveryType(oldOrder.getDeliveryType());
        if(order.getPaymentMethod() == OrderPaymentMethodEnum.CASH){
            oldOrder.setStatus(OrderStatusEnum.PENDING_SHIPPING);
            //orderService.updateOrder(order);
        }
        orderService.updateOrder(oldOrder);
        return "redirect:/order?id=" + order.getId();
    }

    /**
     * Order pay.
     *
     * @param model   the model
     * @param orderId the order id
     * @return the string
     */
    @RequestMapping(value = "/orderPay", method = RequestMethod.GET)
    public String orderPay(Model model, @RequestParam("id") Integer orderId) {
        if (!isCurrentAuthenticationAnonymous()) {
            OrderEntity order = orderService.getOrderById(orderId);
            orderService.pushOrderStatus(order);
        }
        return "redirect:/order?id=" + orderId;
    }

    /**
     * List user orders.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = {"/orders-list"}, method = RequestMethod.GET)
    public String listUserOrders(Model model) {

        if (!isCurrentAuthenticationAnonymous()) {
            UserEntity user = userService.findByName(getPrincipal());
            try {
                List<OrderEntity> userOrders = orderService.getOrdersListByUser(user);
                model.addAttribute("orders", userOrders);
            } catch (OrdersNotFoundException ex) {
                return "/index";
            }
            return "/orders-list";
        } else {
            return "/login";
        }

    }

    /**
     * Create order from cart.
     *
     * @param model the model
     * @return the string
     */
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
            } catch (NoGoodsInStockException e){
                return "/cart";
            }
        } else {
            if ((sessionCart.getCartItemsList() != null) && (!sessionCart.getCartItemsList().isEmpty())) {
                //authHandler.setOrderFlag(true);
                sessionCart.setOrderFlag(true);
                return "/login";
            } else {
                return "redirect:/cart";
            }
        }
        return "redirect:/order?id=" + id;
    }
}
