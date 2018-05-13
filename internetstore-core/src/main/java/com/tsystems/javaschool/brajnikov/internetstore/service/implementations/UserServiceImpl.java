package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.UserDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserEntity findById(int id) {
        return dao.findById(id);
    }

    public List<UserEntity> findAllUsers() {
        return dao.findAllUsers();
    }

    public UserEntity findByEmail(String useremail) {
        return dao.findByEmail(useremail);
    }

    public UserEntity findByName(String username) {
        return dao.findByName(username);
    }
    public void save(UserEntity userEntity) {
        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        dao.create(userEntity); //TODO save = create + update???
    }
}
