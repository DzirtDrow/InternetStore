package com.tsystems.javaschool.brajnikov.internetstore.controller;

import com.tsystems.javaschool.brajnikov.internetstore.dto.UserRequestDto;
import com.tsystems.javaschool.brajnikov.internetstore.model.AddressEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.AddressService;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.UserService;
import com.tsystems.javaschool.brajnikov.internetstore.enums.RoleEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * The type Account controller.
 */
@Controller("accountController")
public class AccountController extends AbstractController {

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

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
        AddressEntity addressEntity = user.getAddress();
        model.addAttribute("useraddress", addressEntity);
        logger.info("Showing Account page for user: {}", user.getName());

        return "/account";
    }

    /**
     * Edit account.
     *
     * @param userRequestDto the user entity
     * @param address        the AddressEntity
     * @param model          the model
     * @return the string
     */
    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String editAccount(@ModelAttribute("user") UserRequestDto userRequestDto,
                              @ModelAttribute("useraddress") AddressEntity address,
                              Model model) {

        UserEntity user = userService.findByEmail(userRequestDto.getEmail());
        address.setUser(user); //TODO

        if(addressService.findAddressByUserId(user.getId()) == null){
            address.setId(userService.findByEmail(userRequestDto.getEmail()).getAddress().getId()); //TODO monstro!, i set address id from user
        }

        addressService.updateAddress(address);

        userRequestDto.setAddressEntity(address);

        userService.updateUserByDto(userRequestDto);

        logger.info("Updating user {} from account page", userRequestDto.getName());
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
     * @param userRequestDto the {@link UserRequestDto}
     * @param model      the model
     * @return the string
     */
    @RequestMapping(value = "/edituserbyadmin", method = RequestMethod.POST)
    public String updateUserByADmin(@ModelAttribute("user") UserRequestDto userRequestDto,
                                    BindingResult result,
                                    RedirectAttributes redirectAttributes,
                                    Authentication authentication,
                                    Model model) {
        logger.info("Updating user {} by admin", userRequestDto.getName());
        userService.updateUserByDto(userRequestDto);
        return "redirect:/list";
    }
}
