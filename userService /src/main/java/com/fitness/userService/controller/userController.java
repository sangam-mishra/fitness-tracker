package com.fitness.userService.controller;

import com.fitness.userService.dto.UserResponse;
import com.fitness.userService.dto.registerRequest;
import com.fitness.userService.service.userService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("samFirst/api/users")
@AllArgsConstructor
public class userController {

    private userService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String userId){
        return ResponseEntity.ok(userService.getUserProfile(userId));
    }

          @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody registerRequest request){
        return ResponseEntity.ok(userService.register(request));
    }
}
