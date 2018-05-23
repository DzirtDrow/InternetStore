package com.tsystems.javaschool.brajnikov.internetstore.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandlingController {

//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView deafaultHandler(HttpServletRequest req, Exception e){
//
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url", req.getRequestURL());
//        mav.setViewName("/error");
//        return mav;
//    }
}
