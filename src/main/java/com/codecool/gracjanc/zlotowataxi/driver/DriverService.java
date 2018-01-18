package com.codecool.gracjanc.zlotowataxi.driver;

import org.springframework.stereotype.Service;

@Service
public interface DriverService {
    Iterable<Driver> findAll();

    Driver findOne(Integer id);

    void save(Driver driver);

    void delete(Integer id);
}
