package com.tsystems.javaschool.brajnikov.internetstore.service.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dto.UserDto;
import com.tsystems.javaschool.brajnikov.internetstore.exception.EmailIsUsedException;
import com.tsystems.javaschool.brajnikov.internetstore.model.AddressEntity;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;

import java.util.List;

/**
 * The interface User service.
 */
public interface UserService {

    /**
     * Find user entity by id.
     *
     * @param id the id
     * @return the {@link UserEntity}
     */
    UserEntity findById(int id);

    /**
     * Find all users list.
     *
     * @return the list of {@link UserEntity}
     */
    List<UserEntity> findAllUsers();

    /**
     * Save user.
     *
     * @param userEntity the {@link UserEntity}
     */
    void save(UserEntity userEntity);

    /**
     * Find user entity by email.
     *
     * @param useremail the user email
     * @return the {@link UserEntity}
     */
    UserEntity findByEmail(String useremail);

    /**
     * Find user entity by name.
     *
     * @param username the username
     * @return the {@link UserEntity}
     */
    UserEntity findByName(String username);

    /**
     * Gets user address.
     *
     * @param user the {@link UserEntity}
     * @return the {@link AddressEntity}
     */
    AddressEntity getUserAddress(UserEntity user);

    /**
     * Register new user .
     *
     * @param user the {@link UserDto}
     * @throws EmailIsUsedException the email is used exception
     */
    void registerUser(UserDto user) throws EmailIsUsedException;

    /**
     * Update user.
     *
     * @param userEntity the {@link UserEntity}
     */
    void updateUser(UserEntity userEntity);
}
