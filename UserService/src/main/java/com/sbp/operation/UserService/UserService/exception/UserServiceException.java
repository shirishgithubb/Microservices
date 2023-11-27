package com.sbp.operation.UserService.UserService.exception;

public class UserServiceException extends RuntimeException {

    public UserServiceException(){
        super("User is not present  !! ");
    }
    public UserServiceException(String msg) {
        super(msg);
    }

}
