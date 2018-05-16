package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.dto.SessionCart;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartItemEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.CartService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.GoodsService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
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

    @Autowired
    CartService cartService;

    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    @RequestMapping(value = {"/store"}, method = RequestMethod.GET)
    public String storeList(Model model) {
        List<GoodsEntity> goods = goodsService.findAllGoods();

        model.addAttribute("loggedinuser", getPrincipal());

        model.addAttribute("goods", goods);

        //String testString = "Before";

        if (!isCurrentAuthenticationAnonymous()) {
            UserEntity user = userService.findByName(getPrincipal());// logged in user
            List<CartItemEntity> cartItemsList = cartService.getCartItems(user.getId());

            // = "After";
            //model.addAttribute("testAttribute", testString);

            model.addAttribute("cartItems", cartItemsList);

        } else {
            //TODO SessionCartHere


        }

        return "/store";
    }

    @RequestMapping(value = "/addtocart")
    public String deleteGoods(Model model, @RequestParam("id") String id) {
        UserEntity user = userService.findByName(getPrincipal());
        if (id != null) {
            if (!isCurrentAuthenticationAnonymous()) {
//                CartEntity userCart = user.getCart();
//                CartItemEntity item = new CartItemEntity();
//                item.setGoods(goodsService.findGoodsById(Integer.parseInt(id)));
                cartService.addGoodsToCart(user.getId(), goodsService.findGoodsById(Integer.parseInt(id)));
            }
        }


        return "redirect:/store";
    }

    @RequestMapping(value = "/cart")
    public String showUserCart(Model model) {
        UserEntity user = userService.findByName(getPrincipal());

        List<CartItemEntity> userCart;
        userCart = cartService.getCartItems(user.getId());
        model.addAttribute("userCart", userCart);

        model.addAttribute("loggedinuser", getPrincipal());
        return "/cart";
    }

    @RequestMapping(value = "/deleteItemFromCart")
    public String deleteItemFromCart(Model model, @RequestParam("id") String id) {
        UserEntity user = userService.findByName(getPrincipal());

        if (id != null) {
            cartService.deleteCartItem(user.getId(), Integer.parseInt(id));
        }
        return "redirect:/cart";
    }
}
