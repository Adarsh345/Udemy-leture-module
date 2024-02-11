package com.adarsh.learing.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sample/")
public class Controller {
    @GetMapping(path = "get")
    public String simpleRest(HttpServletRequest httpRequest){
        return "hello world " + httpRequest.getRequestedSessionId();
    }
}
