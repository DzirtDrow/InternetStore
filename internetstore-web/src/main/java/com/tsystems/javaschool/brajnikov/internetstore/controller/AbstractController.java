package com.tsystems.javaschool.brajnikov.internetstore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;


/**
 * The type Abstract controller with some methods for all controllers.
 */

public abstract class AbstractController {


    public static final String LOGGED_IN_USER_ATTRIBUTE_NAME = "loggedinuser";
    /**
     * The {@link AuthenticationTrustResolver}.
     */
    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    static final Logger logger = LoggerFactory.getLogger(AbstractController.class);

    /**
     * Get principal.
     *
     * @return the authentificated user's username
     */
    protected String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User) {
            userName = ((User) principal).getUsername();
        } else {
            userName = principal.toString();
        }

        logger.info("Getting principal: {}", userName);

        return userName;
    }

    /**
     * Is current authentication anonymous.
     *
     * @return the returns TRUE if current authentication is anonymous
     */
    protected boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("Is current authentification is anonymous? {}", authenticationTrustResolver.isAnonymous(authentication));
        return authenticationTrustResolver.isAnonymous(authentication);
    }

    /**
     * Handle io exception model and view.
     *
     * @param exception the exception
     * @return the model and view
     */
//    @ExceptionHandler(Exception.class)
//    public ModelAndView handleIOException(Exception exception) {
//        ModelAndView modelAndView = new ModelAndView("error");
//        modelAndView.addObject("message", exception.getMessage());
//        return modelAndView;
//    }
}
