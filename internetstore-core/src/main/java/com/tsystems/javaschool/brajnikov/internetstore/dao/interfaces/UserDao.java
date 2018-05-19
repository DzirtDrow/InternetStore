package com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dao.GenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;

import java.util.List;

public interface UserDao extends GenericDao<UserEntity, Integer>{

    UserEntity findById(int id);

    UserEntity findByEmail(String email);
    UserEntity findByName(String username);

    //void save(UserEntity user);

    List<UserEntity> findAllUsers();


}
