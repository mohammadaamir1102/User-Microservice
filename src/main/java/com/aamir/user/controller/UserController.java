package com.aamir.user.controller;

import com.aamir.user.entity.User;
import com.aamir.user.exception.ResourceNotFoundException;
import com.aamir.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User saveUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
    }

    @GetMapping("/findAllUser")
    public ResponseEntity<List<User>> findAllUser(){
        List<User> users = userService.findAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/findByUserId/{userId}")
    public ResponseEntity<User> findByUserId(@PathVariable Long userId) throws ResourceNotFoundException {
        User user = userService.findById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable Long userId) throws ResourceNotFoundException {
        User user = userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
