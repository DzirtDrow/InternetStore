package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.UserDao;
import com.tsystems.javaschool.brajnikov.internetstore.dto.UserDto;
import com.tsystems.javaschool.brajnikov.internetstore.exception.EmailIsUsedException;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.UserService;
import com.tsystems.javaschool.brajnikov.internetstore.util.RoleEnum;
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

    public void registerUser(UserDto user) throws EmailIsUsedException {

        if (dao.findByEmail(user.getEmail()) != null) {
            throw new EmailIsUsedException();
        }

        //TODO сделать проверку на существующего юзера, если есть - эксепшн
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        //userEntity.setLastName(user.getLastname());
        userEntity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userEntity.setRole(RoleEnum.user); //TODO ???
        userEntity.setEmail(user.getEmail());
        //userEntity.setDate(user.getBirthdate());

        dao.create(userEntity);

    }

    public void save(UserEntity userEntity) {
        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        dao.create(userEntity); //TODO save = create + update???
    }
}
