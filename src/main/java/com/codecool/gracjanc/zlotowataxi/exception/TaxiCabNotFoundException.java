package com.codecool.gracjanc.zlotowataxi.exception;

public class TaxiCabNotFoundException extends RuntimeException{

    public TaxiCabNotFoundException(Integer id) {
        super("TaxiCabNotFoundException with id="+id);
    }
}
