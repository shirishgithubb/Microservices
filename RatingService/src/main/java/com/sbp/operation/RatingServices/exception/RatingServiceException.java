package com.sbp.operation.RatingServices.exception;

public class RatingServiceException extends RuntimeException {
    public RatingServiceException(String msg) {
        super(msg);
    }

    public RatingServiceException(){
        super("Rating not present !!");
    }
}
