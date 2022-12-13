package com.aamir.user.controller;

import com.aamir.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/userMicroservice")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
}
