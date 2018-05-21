package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.UserDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.AddressEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.AddressService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("accountController")
public class AccountController extends AbstractController{

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;


    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String showAccountPage(Model model){
        UserEntity user = userService.findByName(getPrincipal());
        model.addAttribute("user", user);
        model.addAttribute("loggedinuser", getPrincipal());
        //AddressEntity address = userService.getUserAddress(user);
        //model.addAttribute("address", address);
        return "/account";
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String editAccount(@ModelAttribute("user") UserEntity userEntity, Model model){

        //userEntity.setAddress();

        userService.updateUser(userEntity);
        //addressService.updateAddress(userService.getUserAddress(userEntity), addr);

        return "redirect:/account";
    }

}
