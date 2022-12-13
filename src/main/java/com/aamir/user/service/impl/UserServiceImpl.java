package com.aamir.user.service.impl;

import com.aamir.user.entity.User;
import com.aamir.user.exception.ResourceNotFoundException;
import com.aamir.user.repo.UserRepository;
import com.aamir.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long userId) throws ResourceNotFoundException {
        return userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException(userId + "user is not exist on server"));
    }


    @Override
    public User deleteUser(Long userId) throws ResourceNotFoundException {
        Optional<User> user = userRepository.findById(userId);
        User userForUpdate = null;
        if (!user.isPresent()) {
            throw new ResourceNotFoundException(userId + "user is not exist");
        } else {
            userForUpdate = user.get();
            userForUpdate.setActiveUser(Boolean.FALSE);
            userRepository.save(userForUpdate);
            return userForUpdate;
        }
    }
}
