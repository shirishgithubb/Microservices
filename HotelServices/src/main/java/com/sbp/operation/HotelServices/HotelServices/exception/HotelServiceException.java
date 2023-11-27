package com.sbp.operation.HotelServices.HotelServices.exception;

public class HotelServiceException extends RuntimeException {
    public HotelServiceException(String msg) {
        super(msg);
    }

    public HotelServiceException(){
        super("Hotel is not present");
    }
}
