package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.dto.SessionCart;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartItemEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.CategoryEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.CartService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.CategoryService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.GoodsService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
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

    @Autowired
    CartService cartService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    @RequestMapping(value = {"/store"}, method = RequestMethod.GET)
    public String storeCategoryList(Model model, @RequestParam("id") Integer categoryId) {

        List<CategoryEntity> categoryEntityList = categoryService.getCategoryList();
        model.addAttribute("categories", categoryEntityList);//TODO replace all Entities to DTO or VB

            List<GoodsEntity> goodsByCategory = categoryService.getGoodsListByCategory(categoryId);
            model.addAttribute("goods", goodsByCategory);

//        List<CartItemEntity> cartItemsList;
        if (!isCurrentAuthenticationAnonymous()) {
            model.addAttribute("loggedinuser", getPrincipal());
            UserEntity user = userService.findByName(getPrincipal());// logged in user
        } else {
            model.addAttribute("loggedinuser", "anonymousUser");
        }
        return "/store";
    }
//
//    @RequestMapping(value = {"/store"}, method = RequestMethod.GET)
//    public String storeList(Model model){
//        List<GoodsEntity> goods = goodsService.findAllGoods();//TODO replace all Entities to DTO or VB
//        model.addAttribute("goods", goods);
//        return "/store";
//    }

    @RequestMapping(value = "/addtocart")
    public String deleteGoods(Model model, @RequestParam("id") Integer id) {
        //UserEntity user = userService.findByName(getPrincipal());

        if (id != null) {
            if (!isCurrentAuthenticationAnonymous()) {
                UserEntity user = userService.findByName(getPrincipal());

                cartService.addGoodsToCart(user.getId(), goodsService.findGoodsById(id));
            } else {
                sessionCart.addItemToSessionCart(goodsService.findGoodsById(id));
            }
        }

        int cat = goodsService.findGoodsById(id).getCategory().getId(); //TODO monster construction, need to refactor
        return "redirect:/store?id=" + cat;
    }

    @RequestMapping(value = "/cart")
    public String showUserCart(Model model) {
        List<CartItemEntity> cartItemsList;
        if (!isCurrentAuthenticationAnonymous()) {
            UserEntity user = userService.findByName(getPrincipal());
            cartItemsList = cartService.getCartItems(user.getId());

            model.addAttribute("userCart", cartItemsList);

            model.addAttribute("loggedinuser", getPrincipal());

        } else {
            //TODO SessionCartHere
            cartItemsList = sessionCart.getCartItemsList();
            model.addAttribute("userCart", cartItemsList);
            model.addAttribute("loggedinuser", "anonymousUser");
        }
//        List<CartItemEntity> userCart;
//        userCart = cartService.getCartItems(user.getId());
//        model.addAttribute("userCart", userCart);

        //model.addAttribute("loggedinuser", getPrincipal());
        return "/cart";
    }

    @RequestMapping(value = "/deleteItemFromCart")
    public String deleteItemFromCart(Model model, @RequestParam("id") String id) {
        if (!isCurrentAuthenticationAnonymous()) {
            UserEntity user = userService.findByName(getPrincipal());
            if (id != null) {
                cartService.deleteCartItem(Integer.parseInt(id));
            }
        } else {
            sessionCart.deleteItemFromCart(Integer.parseInt(id));
        }

        return "redirect:/cart";
    }

    @RequestMapping(value = "/increaseItemsCount")
    public String increaseItemCount(Model model, @RequestParam("id") String id) {
        if (!isCurrentAuthenticationAnonymous()) {
            if (id != null) {
                cartService.increaseItemsCount(Integer.parseInt(id));
            }
        } else {
            sessionCart.increaseItemCount(Integer.parseInt(id));
        }
        return "redirect:/cart";
    }

    @RequestMapping(value = "/decreaseItemsCount")
    public String decreaseItemCount(Model model, @RequestParam("id") String id) {
        if (!isCurrentAuthenticationAnonymous()) {
            if (id != null) {
                cartService.decreaseItemsCount(Integer.parseInt(id));
            }
        } else {
            sessionCart.decreaseItemCount(Integer.parseInt(id));
        }
        return "redirect:/cart";
    }

}
