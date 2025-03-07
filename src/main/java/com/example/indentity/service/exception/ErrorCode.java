package com.example.indentity.service.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999 , "uncategorized error"),
    INVALID_KEY(1001, "invalid message key "),
    USER_EXISTED(1001 , "User existed"),
    USERNAME_INVALID(1003 , "Username must be atleast 3 characters"),
    INVALID_PASSWORD(1004 , "Password must be atleast 8 characters")
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code ;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
