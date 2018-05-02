package com.tsystems.javaschool.brajnikov.internetstore.dao;

import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface UserDao {

    UserEntity findById(int id);

    void save(UserEntity user);

    List<UserEntity> findAllUsers();
}
