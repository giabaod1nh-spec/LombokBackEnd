package com.example.indentity.service.dto.request;

import com.example.indentity.service.exception.ErrorCode;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
//default cac field se la private
public class UserCreationRequest {
    String id;


    @Size(min = 3 ,message = "USERNAME_INVALID")
    String username;


    @Size(min = 8, message = "INVALID_PASSWORD")
    String password;
    String firstName;
    String lastName;
    LocalDate dob ;


}
