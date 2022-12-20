package com.aamir.user.service.impl;

import com.aamir.user.dto.PaginationDTO;
import com.aamir.user.entity.User;
import com.aamir.user.exception.ResourceNotFoundException;
import com.aamir.user.exception.ServiceException;
import com.aamir.user.repo.UserRepository;
import com.aamir.user.service.PaginationService;
import com.aamir.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PaginationService paginationService;

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
                () -> new ResourceNotFoundException("User id: " + userId + " is not Exist !"));
    }


    @Override
    public User deleteUser(Long userId) throws ResourceNotFoundException {
        Optional<User> user = userRepository.findById(userId);
        User userForUpdate = null;
        if (!user.isPresent()) {
            throw new ResourceNotFoundException("User id: " + userId + " is not Exist !");
        } else {
            userForUpdate = user.get();
            userForUpdate.setActiveUser(Boolean.FALSE);
            userRepository.save(userForUpdate);
            log.info("/* deleted user {} */ ", userForUpdate);
            return userForUpdate;
        }
    }

    @Override
    public Map findAllUsers(PaginationDTO paginationDTO) throws ServiceException {
        Page<User> users = userRepository.findAll(paginationService.getPagination(paginationDTO));
        List<User> activeUsers = users.stream().filter(activeUser -> activeUser.getActiveUser() != false).collect(Collectors.toList());
        log.info("/* user records {} */", activeUsers);
        Map<String, Object> datamap = new HashMap<>();
        datamap.put("data", activeUsers);
        datamap.put("totalPage", users.getTotalPages());
        datamap.put("currentPage", users.getNumber());
        datamap.put("totalRecords", activeUsers.size());
        return datamap;
    }

    @Override
    public Optional<User> findTop1ByUserName(String userName) {
        return userRepository.findTop1ByUserNameOrderByCreatedOnDesc(userName);
    }
}
