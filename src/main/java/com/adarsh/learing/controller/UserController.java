package com.adarsh.learing.controller;

import com.adarsh.learing.model.User;
import com.adarsh.learing.securityImpl.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserServiceInterface userService;

    private BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder(12);

    @PostMapping(path = "/register")
    public User userRegister(@RequestBody User user){
        user.setPassword(cryptPasswordEncoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        return  userService.registerUser(user);


    }
}
