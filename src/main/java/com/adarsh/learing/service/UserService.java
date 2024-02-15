package com.adarsh.learing.service;

import com.adarsh.learing.model.User;
import com.adarsh.learing.repository.UserRepo;
import com.adarsh.learing.securityImpl.UserDetailsServiceImpl;
import com.adarsh.learing.securityImpl.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService, UserServiceInterface {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepo.findByUsername(username);
        System.out.println(user);

        if(user == null){
            System.out.println("user 404");
            throw  new UsernameNotFoundException("User not found ");
        }

        return new UserDetailsServiceImpl(user);

    }

    // logic for user registration
    @Override
    public User registerUser(User user) {
        return userRepo.save(user);
    }
}
