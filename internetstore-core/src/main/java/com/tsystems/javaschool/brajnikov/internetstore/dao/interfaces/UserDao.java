package com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces;

import com.tsystems.javaschool.brajnikov.internetstore.dao.GenericDao;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;

import java.util.List;

/**
 * The interface User dao.
 */
public interface UserDao extends GenericDao<UserEntity, Integer>{

    /**
     * Find user entity by id.
     *
     * @param id the id
     * @return the {@link UserEntity}
     */
    UserEntity findById(int id);

    /**
     * Find user entity by email.
     *
     * @param email the email
     * @return the {@link UserEntity}
     */
    UserEntity findByEmail(String email);

    /**
     * Find user entity by name.
     *
     * @param username the username
     * @return the {@link UserEntity}
     */
    UserEntity findByName(String username);

    /**
     * Find all users list.
     *
     * @return the list of {@link UserEntity}
     */
    List<UserEntity> findAllUsers();

    /**
     * Update spent count.
     *
     * @param user the user
     * @param summ the summ
     */
    void updateSpentCount(UserEntity user, int summ);

    /**
     * Gets top users.
     *
     * @param i the
     * @return the top users
     */
    List<UserEntity> getTopUsers(int i);
}
