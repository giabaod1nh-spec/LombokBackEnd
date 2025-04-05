package com.simple.student_trainning_points.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    UNCATOGERIZED_EXCEPTION(9999 , "Uncategorized error"),
    INVALID_KEY(1001, "Uncategorized error"),
    USER_EXISTED(1002, "User existed"),
    INVALID_PASSWORD(1004, "Password must be at least 6 characters")
    ;
    ErrorCode(int code , String message){
        this.code = code;
        this.message = message;
    }
    private int code;
    private String message;
}
