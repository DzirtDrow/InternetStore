package com.tsystems.javaschool.brajnikov.internetstore.dto;

import com.tsystems.javaschool.brajnikov.internetstore.model.AddressEntity;
import com.tsystems.javaschool.brajnikov.internetstore.enums.RoleEnum;
import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;

@Data
public class UserRequestDto {
    @Size(min = 4, max = 64)
    private String name;

    @Size(min = 4, max = 64)
    private String lastname;

    private String date;

    @Email
    private String email;

    @Size(min = 4, max = 32)
    private String password;

    @Size(min = 4, max = 32)
    private String confirmPassword;

    private AddressEntity addressEntity;

    private RoleEnum role;

}
