package com.tsystems.javaschool.brajnikov.internetstore.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {

    // Encryte Password with BCryptPasswordEncoder
    public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static void main(String[] args) {
        //String password = "user";
        //String encrytedPassword = encrytePassword(password);

        //System.out.println( password + " -- Encryted Password: " + encrytedPassword);
    }

}