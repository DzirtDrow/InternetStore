package com.tsystems.javaschool.brajnikov.internetstore.service;

import com.tsystems.javaschool.brajnikov.internetstore.dao.UserDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    public UserEntity findById(int id) {
        return dao.findById(id);
    }

    public List<UserEntity> findAllUsers() {
        return dao.findAllUsers();
    }
}
