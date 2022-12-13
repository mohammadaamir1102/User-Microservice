package com.aamir.user.service;

import com.aamir.user.entity.User;
import com.aamir.user.exception.ResourceNotFoundException;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> findAllUser();

    User findById(Long userId) throws ResourceNotFoundException;

    User deleteById(Long userId);
}
