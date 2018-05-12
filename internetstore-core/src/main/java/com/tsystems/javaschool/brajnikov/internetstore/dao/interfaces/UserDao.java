package com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface UserDao {

    UserEntity findById(int id);

    UserEntity findByEmail(String email);

    //void save(UserEntity user);

    List<UserEntity> findAllUsers();

    //UserEntity getActiveUser(String email);
}
