package com.tsystems.javaschool.brajnikov.internetstore.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;
import java.sql.Date;

/**
 * The type User dto for register and validating.
 */
@Data
public class UserDto {

    @Size(min = 4, max = 64)
    private String name;

    @Size(min = 4, max = 64)
    private String lastname;

    private Date date;

    @Email
    private String email;

    @Size(min = 4, max = 32)
    private String password;

    @Size(min = 4, max = 32)
    private String confirmPassword;
}