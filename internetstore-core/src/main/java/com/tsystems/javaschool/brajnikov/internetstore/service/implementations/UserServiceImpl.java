package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.AddressDao;
import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.UserDao;
import com.tsystems.javaschool.brajnikov.internetstore.dto.UserRequestDto;
import com.tsystems.javaschool.brajnikov.internetstore.enums.RoleEnum;
import com.tsystems.javaschool.brajnikov.internetstore.exception.EmailIsUsedException;
import com.tsystems.javaschool.brajnikov.internetstore.model.AddressEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserEntity findById(int id) {
        return userDao.findById(id);
    }

    public List<UserEntity> findAllUsers() {
        return userDao.findAllUsers();
    }

    public UserEntity findByEmail(String useremail) {
        return userDao.findByEmail(useremail);
    }

    public UserEntity findByName(String username) {
        UserEntity userEntity;
        try {
            userEntity = userDao.findByName(username);
        } catch (NoResultException ex) {
            return null;
        }
        return userEntity;
    }

    public void registerUser(UserRequestDto user) throws EmailIsUsedException {

        if (userDao.findByEmail(user.getEmail()) != null) {
            throw new EmailIsUsedException();
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userEntity.setRole(RoleEnum.user);
        userEntity.setEmail(user.getEmail());

        userDao.create(userEntity);

    }

    public void updateUser(UserEntity userEntity) {
        userDao.update(userEntity);
    }

    public void updateUserByDto(UserRequestDto userRequestDto) {
        UserEntity user = userDao.findByEmail(userRequestDto.getEmail());
        user.setLastname(userRequestDto.getLastname());
        user.setAddress(userRequestDto.getAddressEntity()); //TODO ???
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(userRequestDto.getDate());
        } catch (ParseException e) {
            e.printStackTrace(); //TODO logger
        }
        user.setDate(date);

        userDao.update(user);

    }

    @Override
    public List<UserEntity> getTopUsers(int i) {
        return userDao.getTopUsers(i);
    }

    public AddressEntity getUserAddress(UserEntity user) {
        if (user.getAddress() == null) {
            AddressEntity newAddress = new AddressEntity();
            newAddress.setAddress("");
            newAddress.setCoordinates("");
            newAddress.setUser(user);
            addressDao.create(newAddress);
            user.setAddress(newAddress);

        }
        return user.getAddress();
    }

    public void save(UserEntity userEntity) {
        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        userDao.create(userEntity);
    }
}
