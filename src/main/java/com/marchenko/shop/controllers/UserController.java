package com.marchenko.shop.controllers;

import com.marchenko.shop.components.users.User;
import com.marchenko.shop.components.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user/info", method = RequestMethod.GET)
    public String getUserInfo() {
        return "{\"test\":\"test\"}";
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public String registerNewUser(@RequestBody User user) {
        userService.saveUser(user);
        return "ok";
    }

}
