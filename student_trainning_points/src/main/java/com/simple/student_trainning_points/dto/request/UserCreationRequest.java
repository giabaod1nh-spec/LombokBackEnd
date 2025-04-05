package com.simple.student_trainning_points.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    String userId;
    
    @Size(min = 6, message = "INVALID_PASSWORD")
    String password;
    
    @NotNull
    Integer roleId;
    
    boolean isActive = true;
}

