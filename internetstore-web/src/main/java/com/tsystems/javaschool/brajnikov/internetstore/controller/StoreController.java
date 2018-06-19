package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.dto.SessionCart;
import com.tsystems.javaschool.brajnikov.internetstore.filter.PriceFilter;
import com.tsystems.javaschool.brajnikov.internetstore.model.*;
import com.tsystems.javaschool.brajnikov.internetstore.service.implementations.CustomAuthentificationSuccessHandler;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.CartService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.CategoryService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.GoodsService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.UserService;
import com.tsystems.javaschool.brajnikov.internetstore.enums.SortingTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public String storeCategoryList(Model model,
                                    @RequestParam("id") Integer categoryId,
                                    @RequestParam(value = "min", required = false) Integer priceMin,
                                    @RequestParam(value = "max", required = false) Integer priceMax,
                                    @RequestParam(value = "sorttype", required = false) String sorttype
    ) {

        List<CategoryEntity> categoryEntityList = categoryService.getCategoryList();
        model.addAttribute("categories", categoryEntityList);

        model.addAttribute("currentCategory", categoryService.getCategoryById(categoryId));

        CategoryEntity categoryEntity = categoryService.getCategoryById(categoryId);
        List<ParameterEntity> parameterEntityList = categoryEntity.getParameters();
        model.addAttribute("parameters", parameterEntityList);

        if(priceMin == null) {
            priceMin = 0;
        }
        if(priceMax == null) {
            priceMax = categoryService.getMaxPriceForCategory(categoryEntity);
        }
        List<GoodsEntity> goodsByCategory = categoryService.getGoodsListByCategory(categoryId);
        //model.addAttribute("goods", goodsByCategory);


        List<GoodsEntity> goodsByFilters = categoryService.getGoodsListByFilter(categoryEntity, priceMin, priceMax, sorttype);
        model.addAttribute("goods", goodsByFilters);

        PriceFilter priceFilter = new PriceFilter(priceMin, priceMax);
        model.addAttribute("pricefilter", priceFilter);

        model.addAttribute("sorttypes", SortingTypeEnum.values());

        return "/store";
    }

    /**
     * Delete goods string.
     *
     * @param id the id
     * @return the string
     */
    @RequestMapping(value = "/addtocart")
    public ModelAndView addGoods(@ModelAttribute("goods") GoodsEntity goods, BindingResult result, @RequestParam("id") Integer id) {
        int cat = goodsService.findGoodsById(id).getCategory().getId();
        ModelAndView modelAndView = new ModelAndView("redirect:/store?id=" + cat);
        if (id != null) {
            if (!isCurrentAuthenticationAnonymous()) {
                UserEntity user = userService.findByName(getPrincipal());

                //try to add goods in cart
                if (cartService.addGoodsToCart(user.getId(), goodsService.findGoodsById(id))) {
                    //success
                } else {
                    result.rejectValue("name", "Size.userForm.username");

                    //errorr (if goods count =0)
                }
            } else {
                //TODO сделать то же для sessioncart
                sessionCart.addItemToSessionCart(goodsService.findGoodsById(id));
            }
        }


        return modelAndView;
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

        } else {
            cartItemsList = sessionCart.getCartItemsList();
            model.addAttribute("userCart", cartItemsList);
            model.addAttribute("totalPrice", sessionCart.getCartTotalPrice());
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
    public String increaseItemCount(Model model, @RequestParam("id") Integer id) {
        if (!isCurrentAuthenticationAnonymous()) {
            if (id != null) {
                //TODO check items count
                CartItemEntity item = cartService.getCartItemById(id);
                if (item.getCount() < goodsService.findGoodsById(item.getGoods().getId()).getLeftCount()) {
                    cartService.increaseItemsCount(id);
                } else {
                    //TODO Должна быть ошибка преаышения количества
                }

            }
        } else {
            //TODO для sessioncart сделать то же
            sessionCart.increaseItemCount(id);
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
        GoodsEntity goods = goodsService.findGoodsById(goodsId);
        model.addAttribute("goods", goods);

        List<GoodsParameterEntity> goodsParameters = goods.getGoodsParameterList();

        model.addAttribute("goodsParameters", goodsParameters);
        return "/details";
    }


}
