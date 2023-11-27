package com.sbp.operation.UserService.UserService.exception;

import com.sbp.operation.UserService.UserService.model.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericUserException {

    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<APIResponse> handleUserServiceException(UserServiceException userServiceException) {
        APIResponse apiResponse = APIResponse.builder().message(userServiceException.getMessage()).description("Not Present").httpStatus(HttpStatus.FORBIDDEN).build();
        return new ResponseEntity<APIResponse>(apiResponse,HttpStatus.FORBIDDEN);
    }
}
