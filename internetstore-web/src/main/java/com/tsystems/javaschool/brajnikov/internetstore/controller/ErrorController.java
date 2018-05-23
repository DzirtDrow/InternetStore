package com.tsystems.javaschool.brajnikov.internetstore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController {

    static final Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @RequestMapping(value = "errors", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {

        ModelAndView errorPage = new ModelAndView("error");
        String errorMsg = "test";
        int httpErrorCode = getErrorCode(httpRequest);

        if (httpErrorCode == 400) {
            errorMsg = "Http Error Code: 400. Bad Request";
        } else if (httpErrorCode == 401) {
            errorMsg = "Http Error Code: 401. Unauthorized";
        } else if (httpErrorCode == 404) {
            errorMsg = "Http Error Code: 404. Resource not found";
        } else if (httpErrorCode == 500) {
            errorMsg = "Http Error Code: 500. Internal Server Error";
        }
        errorPage.addObject("errorMsg", errorMsg);
        return errorPage;
    }

    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
                .getAttribute("javax.servlet.error.status_code");
    }
}