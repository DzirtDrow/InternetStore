package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.UserDao;
import com.tsystems.javaschool.brajnikov.internetstore.dto.UserRequestDto;
import com.tsystems.javaschool.brajnikov.internetstore.enums.RoleEnum;
import com.tsystems.javaschool.brajnikov.internetstore.exception.EmailIsUsedException;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceImplTest {

    @Mock
    private UserDao userDao;
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void findById() {
        initMocks(this);

        UserEntity user = new UserEntity();
        user.setId(100);
        when(userDao.findById(100)).thenReturn(user);

        UserEntity testUser = userService.findById(100);

        assertNotNull(testUser);
        assertEquals(user,testUser);
    }

    @Test
    public void findAllUsers() {
        initMocks(this);

        when(userDao.findAllUsers()).thenReturn(getTestUsersList());

        List<UserEntity> testList = userService.findAllUsers();

        assertNotNull(testList);
        assertEquals(getTestUsersList(), testList);

    }

    @Test
    public void findByEmail() {
        initMocks(this);

        UserEntity user = new UserEntity();
        user.setEmail("test@test.ru");
        when(userDao.findByEmail("test@test.ru")).thenReturn(user);

        UserEntity testUser = userService.findByEmail("test@test.ru");

        assertNotNull(testUser);
        assertEquals(testUser,user);
    }

    @Test
    public void findByName() {
        initMocks(this);

        UserEntity user = new UserEntity();
        user.setName("test");
        when(userDao.findByEmail("test")).thenReturn(user);

        UserEntity testUser = userService.findByEmail("test");

        assertNotNull(testUser);
        assertEquals(testUser,user);
    }

    @Test
    public void registerUser() {
        initMocks(this);

        UserEntity user = new UserEntity();
        user.setName("test");
        user.setEmail("test@test.ru");
        user.setPassword("test");
        user.setRole(RoleEnum.user);

        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setName("test");
        userRequestDto.setEmail("test@test.ru");
        userRequestDto.setPassword("test");

        when(userDao.findByEmail("test@test.ru")).thenReturn(null);
        when(bCryptPasswordEncoder.encode("test")).thenReturn("test");

        try {
            userService.registerUser(userRequestDto);
        } catch (EmailIsUsedException ex){

        }

        verify(userDao).create(user);

    }

    @Test
    public void updateUser() {
        initMocks(this);
        UserEntity user = new UserEntity();

        userService.updateUser(user);

        verify(userDao).update(user);
    }

    @Test
    public void updateUserByDto() {

    }

    @Test
    public void getTopUsers() {
        initMocks(this);

        userService.getTopUsers(10);

        verify(userDao).getTopUsers(10);
    }


    @Test
    public void save() {
        initMocks(this);
        UserEntity user = new UserEntity();

        userService.save(user);

        verify(userDao).create(user);
    }

    public List<UserEntity> getTestUsersList() {
        List<UserEntity> testUsersList = new ArrayList<>();
        testUsersList.add(new UserEntity());
        testUsersList.add(new UserEntity());
        return testUsersList;
    }
}