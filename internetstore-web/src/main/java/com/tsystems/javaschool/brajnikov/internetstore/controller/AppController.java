package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.dto.SessionCart;
import com.tsystems.javaschool.brajnikov.internetstore.model.CategoryEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.CategoryService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.GoodsService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Date;
import java.util.List;

/**
 * The type App controller.
 */
@Controller("appController")
@RequestMapping("/")
public class AppController extends AbstractController {

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
     * The Category service.
     */
    @Autowired
    CategoryService categoryService;

    /**
     * The Persistent token based remember me services.
     */
    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    /**
     * The Logger.
     */
    static final Logger logger = LoggerFactory.getLogger(AppController.class);

    /**
     * Home page.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = {"/", "/home", "/index"}, method = RequestMethod.GET)
    public String home(ModelMap model) {

        if (!isCurrentAuthenticationAnonymous()) {
            model.addAttribute("loggedinuser", getPrincipal());

        } else {
            model.addAttribute("loggedinuser", "anonymousUser");
        }
        logger.info("Showing index page");
        List<CategoryEntity> categoryEntityList = categoryService.getCategoryList();
        model.addAttribute("categories", categoryEntityList);

        return "index";
    }

    /**
     * Login page.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(ModelMap model) {
        logger.info("Login page showing");
        if (isCurrentAuthenticationAnonymous()) {
            return "login";
        } else {
            logger.info("Trying to show Login page when user is already authentificated. User: {}", getPrincipal());
            return "redirect:/index";
        }
    }

    /**
     * List users.
     *
     * @param model     the model
     * @return the string
     */
    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model, Principal principal) {
        List<UserEntity> users = userService.findAllUsers();
        model.addAttribute("time", new Date().toString());

        model.addAttribute("loggedinuser", getPrincipal());
        model.addAttribute("users", users);

        return "list";
    }

    /**
     * Logout page string.
     *
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @return the string
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        model.addAttribute("loggedinuser", "anonymousUser");
        return "redirect:/index";
    }

    /**
     * Access denied page string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("loggedinuser", getPrincipal());
        return "accessdenied";
    }


}
