package com.tsystems.javaschool.brajnikov.internetstore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorController {

    static final Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @ExceptionHandler(Exception.class)
    public String renderErrorPage(HttpServletRequest httpRequest, Model model, Exception ex) {

        String errorMsg = ex.getCause().toString();
        logger.error("Exceprion handling {}", ex);
        model.addAttribute("errorMsg", errorMsg);
        return "/error";
    }

}