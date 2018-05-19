package com.tsystems.javaschool.brajnikov.internetstore.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;
import java.sql.Date;

@Data
public class UserDto {

    @Size(min = 2, max = 64)
    private String name;

    @Size(min = 2, max = 64)
    private String lastname;

    private Date birthdate;

    @Email
    private String email;

    @Size(min = 6, max = 32)
    private String password;

    @Size(min = 6, max = 32)
    private String confirmPassword;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public Date getBirthdate() {
//        return birthdate;
//    }
//
//    public void setBirthdate(Date birthdate) {
//        this.birthdate = birthdate;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getConfirmPassword() {
//        return confirmPassword;
//    }
//
//    public void setConfirmPassword(String confirmPassword) {
//        this.confirmPassword = confirmPassword;
//    }
}