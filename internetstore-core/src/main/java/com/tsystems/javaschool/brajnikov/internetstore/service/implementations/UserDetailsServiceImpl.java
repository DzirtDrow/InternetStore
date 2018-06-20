package com.tsystems.javaschool.brajnikov.internetstore.service.implementations;

import com.tsystems.javaschool.brajnikov.internetstore.dao.interfaces.UserDao;
import com.tsystems.javaschool.brajnikov.internetstore.dto.SessionCart;
import com.tsystems.javaschool.brajnikov.internetstore.model.UserEntity;
import com.tsystems.javaschool.brajnikov.internetstore.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsServiceImpl")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private OrderService orderService;

    private SessionCart sessionCart;

    @Autowired
    public void setSessionCart(SessionCart sessionCart) {
        this.sessionCart = sessionCart;
    }

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UserEntity currentUser = userDao.findByName(username);

        if(sessionCart.isOrderFlag()){
            orderService.createOrderFromSessionCart(currentUser, sessionCart);

        }
        sessionCart.setOrderFlag(false);

        if(currentUser == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        grantList.add(new SimpleGrantedAuthority("ROLE_"+currentUser.getRole().toString()));

        return new User(currentUser.getName(), currentUser.getPassword(),
                true, true,true,true,
                grantList);
    }



}