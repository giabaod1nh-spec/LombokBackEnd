package com.simple.student_trainning_points.service;


import com.simple.student_trainning_points.dto.request.UserCreationRequest;
import com.simple.student_trainning_points.dto.request.UserUpdateRequest;
import com.simple.student_trainning_points.entity.User;
import com.simple.student_trainning_points.repository.RoleRepository;
import com.simple.student_trainning_points.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    
    public User createUser(UserCreationRequest request){
        User user = new User();

        user.setUserId(request.getUserId());
        user.setPassword(request.getPassword());
        user.setRoleId(request.getRoleId());

        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(String userId){
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(String userId , UserUpdateRequest request){
         User user = getUser(userId);
         user.setPassword(request.getPassword());
         user.setRoleId(request.getRoleId());

         return  userRepository.save(user);
    }

    public String deactiveUser(String userId){
        User user = getUser(userId);
        user.setActive(false);
        userRepository.save(user);
        return "User has been deactivated";
    }

    public String activateUser(String userId){
        User user = getUser(userId);
        user.setActive(true);
        userRepository.save(user);
        return  "User has been reactivated";
    }
}
