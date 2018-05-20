package com.tsystems.javaschool.brajnikov.internetstore.service.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dto.UserDto;
import com.tsystems.javaschool.brajnikov.internetstore.exception.EmailIsUsedException;
import com.tsystems.javaschool.brajnikov.internetstore.model.PersistentLogin;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity findById(int id);

    List<UserEntity> findAllUsers();

    void save(UserEntity userEntity);

    UserEntity findByEmail(String useremail);
    UserEntity findByName(String username);

    void registerUser(UserDto user) throws EmailIsUsedException;
}
