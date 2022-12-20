package com.aamir.user.service;

import com.aamir.user.dto.PaginationDTO;
import com.aamir.user.entity.User;
import com.aamir.user.exception.ResourceNotFoundException;
import com.aamir.user.exception.ServiceException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {

    User saveUser(User user);

    List<User> findAllUser();

    User findById(Long userId) throws ResourceNotFoundException;


    User deleteUser(Long userId) throws ResourceNotFoundException;

    Map findAllUsers(PaginationDTO paginationDTO) throws ServiceException;

    Optional<User> findTop1ByUserName(String userName);
}
