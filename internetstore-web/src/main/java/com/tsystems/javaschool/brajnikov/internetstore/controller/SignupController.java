package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.dto.UserDto;
import com.tsystems.javaschool.brajnikov.internetstore.model.GoodsEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.GoodsService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.UserService;
import com.tsystems.javaschool.brajnikov.internetstore.util.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/signup")
public class SignupController extends AbstractController{
    @Autowired
    UserService userService;
    /**
     * This method will provide the medium to add a new user.
     */
    @RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        model.addAttribute("user", new UserDto());
        return "signup";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     */
    @RequestMapping(value = { "/signup" }, method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user")UserDto user, BindingResult result,
                           ModelMap model) {
        //try {
            userService.registerUser(user);
        //} catch (EmailIsUsedException e) {
        //    return "signup";
        //}
        return "/index";
    }


}
