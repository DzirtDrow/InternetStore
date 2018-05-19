package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.dto.UserDto;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        UserDto userDto = new UserDto();

        userDto.setEmail("q@q.q");
        userDto.setName("qqq");
        userDto.setLastname("www");
        userDto.setPassword("1234");
        userDto.setConfirmPassword("1234");

        model.addAttribute("user", userDto);
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
            //userService.registerUser(user);
        //} catch (EmailIsUsedException e) {
        //    return "signup";
        //}
        return "/index";
    }


}
