package com.sbp.operation.HotelServices.HotelServices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GenericException {
    @ExceptionHandler(HotelServiceException.class)
    public ResponseEntity<Map<String,Object>> handleHotelServiceException(HotelServiceException exception) {
        Map<String,Object> objectMap = new HashMap<>();
        objectMap.put("message" , exception.getMessage());
        objectMap.put("result", "Fail");
        objectMap.put("status", HttpStatus.FORBIDDEN);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(objectMap);
    }
}
