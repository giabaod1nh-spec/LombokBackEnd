package com.example.indentity.service.controller;

import com.example.indentity.service.dto.request.APIResponse;
import com.example.indentity.service.dto.request.UserCreationRequest;
import com.example.indentity.service.dto.request.UserUpdateRequest;
import com.example.indentity.service.entity.User;
import com.example.indentity.service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControlller {
    @Autowired
    private UserService userService ;

    @PostMapping
    APIResponse<User> createUser(@RequestBody @Valid UserCreationRequest request){
        APIResponse<User> apiResponse = new APIResponse<>();
        apiResponse.setResult(userService.createUser(request));
        return apiResponse;
    }

    @GetMapping
    List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userId){
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable String userId , @RequestBody UserUpdateRequest request){
         return userService.updateUser(userId , request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return "User has been deleted" ;
    }
}
