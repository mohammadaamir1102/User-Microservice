package com.aamir.user.controller;

import com.aamir.user.dto.PaginationDTO;
import com.aamir.user.entity.User;
import com.aamir.user.exception.ResourceNotFoundException;
import com.aamir.user.exception.ServiceException;
import com.aamir.user.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        log.info("/* inside the UserController, user {} */ ", user);
        User saveUser = userService.saveUser(user);
        log.info("/* saved Successfully , user {} */ ", saveUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
    }

    @GetMapping("/findAllUser")
    public ResponseEntity<List<User>> findAllUser() {
        List<User> users = userService.findAllUser();
        log.info("/* users {} */ ", users);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/findByUserId/{userId}")
    @CircuitBreaker(name = "ratingHotelCircuitBreaker", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> findByUserId(@PathVariable Long userId) throws ResourceNotFoundException {
        log.info("/* users id  {} */ ", userId);
        User user = userService.findById(userId);
        log.info("/* user data {} */ ", user);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

//    creating fall back method for circuit-breaker
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception e) {
        log.info("Fallback is executed because some issue is happened in Service {}", e.getMessage());
        User user = User.builder()
                .userEmail("fallback@gmail.com")
                .userName("fallback name")
                .about("fallback about")
                .userId(342423L)
                .build();
        // need to configuration of resilience 4j in yml file
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable Long userId) throws ResourceNotFoundException {
        log.info("/* users id  {} */ ", userId);
        User user = userService.deleteUser(userId);
        log.info("/* delete user data {} */ ", user);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    //Getting all Users with Pagination
    @GetMapping("/findAllUsers/{page}/{offset}")
    public ResponseEntity<Map> findAllUsers(@PathVariable Long page, @PathVariable Long offset) throws ServiceException {
        PaginationDTO paginationDTO = new PaginationDTO();
        paginationDTO.setPageNumber(page.intValue());
        paginationDTO.setOffset(offset.intValue());
        log.info("/* pagination is  {} */ ", paginationDTO);
        Map allUsers = userService.findAllUsers(paginationDTO);
        log.info("/* all users {} */ ", allUsers);
        return ResponseEntity.status(HttpStatus.OK).body(allUsers);
    }

    //  below api only for learning purpose
    @GetMapping("/findTop1ByUserName/{userName}")
    public ResponseEntity<User> findTop1ByUserName(@PathVariable String userName) throws ResourceNotFoundException {
        log.info("/* user name {} */ ", userName);
        Optional<User> userOptional = userService.findTop1ByUserName(userName);
        log.info("/* user data {} */ ", userOptional);
        User user = userOptional.get();
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
