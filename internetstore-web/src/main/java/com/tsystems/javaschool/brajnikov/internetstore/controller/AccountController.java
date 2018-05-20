package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.UserDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("accountController")
public class AccountController extends AbstractController{
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String showAccountPage(Model model){
        UserEntity user = userService.findByName(getPrincipal());
        model.addAttribute("user", user);
        return "/account";
    }
}
