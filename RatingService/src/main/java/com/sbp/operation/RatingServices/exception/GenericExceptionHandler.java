package com.sbp.operation.RatingServices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(RatingServiceException.class)
    public ResponseEntity<Map<String,Object>> handleRatingServiceException(RatingServiceException exception){
        Map<String,Object> objectMap = new HashMap<>();
        objectMap.put("message",exception.getMessage());
        objectMap.put("status", HttpStatus.FORBIDDEN);

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(objectMap);

    }
}
