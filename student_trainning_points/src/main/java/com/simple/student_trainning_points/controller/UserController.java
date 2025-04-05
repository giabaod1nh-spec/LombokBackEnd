package com.simple.student_trainning_points.controller;


import com.simple.student_trainning_points.dto.request.ApiResponse;
import com.simple.student_trainning_points.dto.request.UserCreationRequest;
import com.simple.student_trainning_points.dto.request.UserUpdateRequest;
import com.simple.student_trainning_points.entity.User;
import com.simple.student_trainning_points.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request){
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
        return apiResponse;
    }

    @GetMapping
    List<User> getUsers(){
        return  userService.getUsers();
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userId){
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable("userId") String userId , @RequestBody UserUpdateRequest request){
       return  userService.updateUser(userId , request);
    }

    @PutMapping("/{userId}/deactive")
    public String deactiveUser(@PathVariable String userId){
            return userService.deactiveUser(userId);
    }


    @PutMapping("/{userId}/active")
    public String activateUser(@PathVariable String userId){
            return userService.activateUser(userId);
    }
}

