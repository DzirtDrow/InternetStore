package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.UserDao;
import com.tsystems.javaschool.brajnikov.internetstore.dto.SessionCart;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * 
 */
public abstract class AbstractController {

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    @Autowired
    private SessionCart sessionCart;

    @Autowired
    private UserDao userDao;

    protected String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User) {
            userName = ((User)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    protected boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }


    @ExceptionHandler(Exception.class)
    public ModelAndView handleIOException(Exception exception) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message", exception.getMessage());
        return modelAndView;
    }
}
