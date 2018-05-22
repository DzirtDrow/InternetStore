package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.dto.UserDto;
import com.tsystems.javaschool.brajnikov.internetstore.exception.EmailIsUsedException;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.UserService;
import com.tsystems.javaschool.brajnikov.internetstore.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignupController extends AbstractController {
    @Autowired
    UserService userService;

    @Autowired
    private UserValidator userValidator;

    /**
     * This method will provide the medium to add a new user.
     */
    @RequestMapping(value = {"/signup"}, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        UserDto userDto = new UserDto();

        model.addAttribute("user", userDto);
        if(!isCurrentAuthenticationAnonymous()){
            model.addAttribute("loggedinuser", getPrincipal());
        } else {
            model.addAttribute("loggedinuser", "anonymousUser");
        }

        return "signup";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     */
    @RequestMapping(value = {"/signup"}, method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user")  UserDto user, BindingResult result,
                           ModelMap model) {
        try {
            userValidator.validate(user, result);
            if (result.hasErrors()){
                    return "signup";
                }
                userService.registerUser(user);
            } catch(EmailIsUsedException ex){
                return "signup";
            }
            return "redirect:/index";
        }


    }
