package com.tsystems.javaschool.brajnikov.internetstore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorController {

    static final Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest, Model model, Exception ex) {

        ModelAndView mav = new ModelAndView("/error");
        String errorMsg = ex.getMessage();
        if(ex.getClass().equals(NullPointerException.class)){
            errorMsg = "Something went wrong, we couldn't find what you need.";
        }

        mav.addObject("errorMsg", errorMsg);

        logger.error("Exception handling {}", ex);
        return mav;
    }

}