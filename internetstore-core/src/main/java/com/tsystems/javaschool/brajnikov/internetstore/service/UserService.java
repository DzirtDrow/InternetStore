package com.tsystems.javaschool.brajnikov.internetstore.service;

import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity findById(int id);

    List<UserEntity> findAllUsers();

}
