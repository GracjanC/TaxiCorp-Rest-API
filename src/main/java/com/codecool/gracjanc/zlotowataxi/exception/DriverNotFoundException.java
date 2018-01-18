package com.codecool.gracjanc.zlotowataxi.exception;

public class DriverNotFoundException extends RuntimeException {

    public DriverNotFoundException(Integer id) {
        super("DriverNotFoundException with id="+id);
    }
}
