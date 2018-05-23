package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.UserService;
import com.tsystems.javaschool.brajnikov.internetstore.util.RoleEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The type Account controller.
 */
@Controller("accountController")
public class AccountController extends AbstractController {

    @Autowired
    private UserService userService;

    /**
     * The Logger.
     */
    static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    /**
     * Show account page.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String showAccountPage(Model model) {
        UserEntity user = userService.findByName(getPrincipal());
        model.addAttribute("user", user);
        model.addAttribute(LOGGED_IN_USER_ATTRIBUTE_NAME, getPrincipal());

        logger.info("Showing Account page for user: {}", user.getName());

        return "/account";
    }

    /**
     * Edit account.
     *
     * @param userEntity the user entity
     * @param model      the model
     * @return the string
     */
    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String editAccount(@ModelAttribute("user") UserEntity userEntity, Model model) {
        userService.updateUser(userEntity);
        logger.info("Updating user {} from account page", userEntity.getName());
        return "redirect:/account";
    }

    /**
     * Edit user.
     *
     * @param model the model
     * @param id    the id
     * @return the string
     */
    @RequestMapping(value = "/edituserbyadmin", method = RequestMethod.GET)
    public String editUser(Model model, @RequestParam("id") Integer id) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("roles", RoleEnum.values());

        logger.info("Edit user by admin page");
        return "/edituserbyadmin";
    }

    /**
     * Update user by admin.
     *
     * @param userEntity the {@link UserEntity}
     * @param model      the model
     * @return the string
     */
    @RequestMapping(value = "/edituserbyadmin", method = RequestMethod.POST)
    public String updateUserByADmin(@ModelAttribute("user") UserEntity userEntity,
                                    Model model) {
        logger.info("Updating user {} by admin", userEntity.getName());
        userService.updateUser(userEntity);
        return "redirect:/list";
    }
}
