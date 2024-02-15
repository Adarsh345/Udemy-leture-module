package com.adarsh.learing.controller;

import com.adarsh.learing.model.User;
import com.adarsh.learing.securityImpl.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserServiceInterface userService;

    @PostMapping(path = "/register")
    public User userRegister(@RequestBody User user){
        return  userService.registerUser(user);


    }
}
