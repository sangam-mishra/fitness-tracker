package com.fitness.userService.service;

import com.fitness.userService.dto.UserResponse;
import com.fitness.userService.dto.registerRequest;
import com.fitness.userService.repository.UserRepository;
import jakarta.validation.Valid;
import com.fitness.userService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {

    @Autowired
    private UserRepository repository;

    public UserResponse register(@Valid registerRequest request) {

        if(repository.existsByuserName(request.getUserName())){
            throw new RuntimeException("username already registered "+request.getUserName());
        }
        User user=new User();
        user.setUserName(request.getUserName());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        User savedUser = repository.save(user);
        UserResponse userResponse=new UserResponse();
        userResponse.setId(savedUser.getId());
        userResponse.setUserName(savedUser.getUserName());
        userResponse.setPassword(savedUser.getPassword());
        userResponse.setFirstName(savedUser.getFirstName());
        userResponse.setLastName(savedUser.getLastName());
        userResponse.setCreation_time(savedUser.getCreation_time());
        userResponse.setUpdatation_time(savedUser.getUpdatation_time());


        return userResponse;

    }

    public UserResponse getUserProfile(String userId) {
        User savedUser=repository.findById(userId).orElseThrow(()->new RuntimeException("user not found"));

        UserResponse userResponse=new UserResponse();
        userResponse.setId(savedUser.getId());
        userResponse.setUserName(savedUser.getUserName());
        userResponse.setPassword(savedUser.getPassword());
        userResponse.setFirstName(savedUser.getFirstName());
        userResponse.setLastName(savedUser.getLastName());
        userResponse.setCreation_time(savedUser.getCreation_time());
        userResponse.setUpdatation_time(savedUser.getUpdatation_time());

        return userResponse;
    }
}
