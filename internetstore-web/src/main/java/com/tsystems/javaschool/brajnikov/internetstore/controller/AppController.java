package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.dto.SessionCart;
import com.tsystems.javaschool.brajnikov.internetstore.model.CategoryEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.PersistentLogin;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.CategoryService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.GoodsService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
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

@Controller("appController")
@RequestMapping("/")
public class AppController extends AbstractController {

    @Autowired
    UserService userService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    SessionCart sessionCart;

    @Autowired
    CategoryService categoryService;

    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;


    @RequestMapping(value = {"/", "/home","/index"}, method = RequestMethod.GET)
    public String home(ModelMap model) {
        if (!isCurrentAuthenticationAnonymous()) {
            model.addAttribute("loggedinuser", getPrincipal());
        } else {
            model.addAttribute("loggedinuser", "anonymousUser");
        }
        List<CategoryEntity> categoryEntityList = categoryService.getCategoryList();
        model.addAttribute("categories", categoryEntityList);//TODO replace all Entities to DTO or VB
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(ModelMap model) {
        if (isCurrentAuthenticationAnonymous()) {
            return "login";
        } else {
            return "redirect:/index";
        }
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model, Principal principal) {
        List<UserEntity> users = userService.findAllUsers();
        model.addAttribute("time", new Date().toString());

        model.addAttribute("loggedinuser", getPrincipal());
        model.addAttribute("users", users);

        return "list";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        model.addAttribute("loggedinuser", "anonymousUser");
        return "redirect:/index";
    }

    @RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("loggedinuser", getPrincipal());
        return "accessdenied";
    }


}
