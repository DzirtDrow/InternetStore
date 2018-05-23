package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.dto.SessionCart;
import com.tsystems.javaschool.brajnikov.internetstore.model.CartItemEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.CategoryEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.implementations.CustomAuthentificationSuccessHandler;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.CartService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.CategoryService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.GoodsService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

/**
 * The type Store controller.
 */
@Controller("storeController")
@SessionAttributes("order")
public class StoreController extends AbstractController {

    /**
     * The User service.
     */
    @Autowired
    UserService userService;

    /**
     * The Goods service.
     */
    @Autowired
    GoodsService goodsService;

    /**
     * The Session cart.
     */
    @Autowired
    SessionCart sessionCart;

    /**
     * The Cart service.
     */
    @Autowired
    CartService cartService;

    /**
     * The Category service.
     */
    @Autowired
    CategoryService categoryService;

    @Autowired
    private CustomAuthentificationSuccessHandler authHandler;

    @Autowired
    private PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    /**
     * The Logger.
     */
    static final Logger logger = LoggerFactory.getLogger(StoreController.class);

    /**
     * Store category list string.
     *
     * @param model      the model
     * @param categoryId the category id
     * @return the string
     */
    @RequestMapping(value = {"/store"}, method = RequestMethod.GET)
    public String storeCategoryList(Model model, @RequestParam("id") Integer categoryId) {

        List<CategoryEntity> categoryEntityList = categoryService.getCategoryList();
        model.addAttribute("categories", categoryEntityList);

        List<GoodsEntity> goodsByCategory = categoryService.getGoodsListByCategory(categoryId);
        model.addAttribute("goods", goodsByCategory);

        if (!isCurrentAuthenticationAnonymous()) {
            model.addAttribute("loggedinuser", getPrincipal());
        } else {
            model.addAttribute("loggedinuser", "anonymousUser");
        }

        return "/store";
    }

    /**
     * Delete goods string.
     *
     * @param model the model
     * @param id    the id
     * @return the string
     */
    @RequestMapping(value = "/addtocart")
    public String deleteGoods(Model model, @RequestParam("id") Integer id) {

        if (id != null) {
            if (!isCurrentAuthenticationAnonymous()) {
                UserEntity user = userService.findByName(getPrincipal());

                cartService.addGoodsToCart(user.getId(), goodsService.findGoodsById(id));
            } else {
                sessionCart.addItemToSessionCart(goodsService.findGoodsById(id));
            }
        }

        int cat = goodsService.findGoodsById(id).getCategory().getId();
        return "redirect:/store?id=" + cat;
    }

    /**
     * Show user cart string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = "/cart")
    public String showUserCart(Model model) {
        List<CartItemEntity> cartItemsList;
        if (!isCurrentAuthenticationAnonymous()) {
            UserEntity user = userService.findByName(getPrincipal());
            cartItemsList = cartService.getCartItems(user.getId());

            model.addAttribute("userCart", cartItemsList);
            model.addAttribute("totalPrice", cartService.getCartTotalPrice(user.getId()));
            model.addAttribute(LOGGED_IN_USER_ATTRIBUTE_NAME, getPrincipal());

        } else {

            cartItemsList = sessionCart.getCartItemsList();

            model.addAttribute("userCart", cartItemsList);
            model.addAttribute("totalPrice", sessionCart.getCartTotalPrice());
            model.addAttribute(LOGGED_IN_USER_ATTRIBUTE_NAME, "anonymousUser");
        }
        return "/cart";
    }

    /**
     * Delete item from cart string.
     *
     * @param model the model
     * @param id    the id
     * @return the string
     */
    @RequestMapping(value = "/deleteItemFromCart")
    public String deleteItemFromCart(Model model, @RequestParam("id") String id) {
        if (!isCurrentAuthenticationAnonymous()) {
            if (id != null) {
                cartService.deleteCartItem(Integer.parseInt(id));
            }
        } else {
            sessionCart.deleteItemFromCart(Integer.parseInt(id));
        }

        return "redirect:/cart";
    }

    /**
     * Increase item count string.
     *
     * @param model the model
     * @param id    the id
     * @return the string
     */
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

    /**
     * Decrease item count string.
     *
     * @param model the model
     * @param id    the id
     * @return the string
     */
    @RequestMapping(value = "/decreaseItemsCount")
    public String decreaseItemCount(Model model, @RequestParam("id") Integer id) {
        if (!isCurrentAuthenticationAnonymous()) {
            if (id != null) {
                cartService.decreaseItemsCount(id);
            }
        } else {
            sessionCart.decreaseItemCount(id);
        }
        return "redirect:/cart";
    }

    /**
     * Goods details string.
     *
     * @param model   the model
     * @param goodsId the goods id
     * @return the string
     */
    @RequestMapping(value = {"/details"}, method = RequestMethod.GET)
    public String goodsDetails(Model model, @RequestParam("id") Integer goodsId) {
        model.addAttribute("goods", goodsService.findGoodsById(goodsId));
        return "/details?id=" + goodsId;
    }


}
