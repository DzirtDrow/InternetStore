package com.tsystems.javaschool.brajnikov.internetstore.validation;

import com.tsystems.javaschool.brajnikov.internetstore.dto.UserDto;

import com.tsystems.javaschool.brajnikov.internetstore.dto.UserRequestDto;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * The type User validator.
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        UserRequestDto user = (UserRequestDto) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.user.Name");
        if (user.getName().length() < 4 || user.getName().length() > 32) {
            errors.rejectValue("name", "Size.userForm.username");
        }

        if (userService.findByName(user.getName()) != null) {
            errors.rejectValue("name", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.user.email");
        if (userService.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("name", "Duplicate.userForm.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.user.password");
        if (user.getPassword().length() < 4 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Diff.userForm.passwordConfirm");
        }
    }
}
