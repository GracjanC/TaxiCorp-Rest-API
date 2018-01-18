package com.codecool.gracjanc.zlotowataxi.driver;

import com.codecool.gracjanc.zlotowataxi.exception.DriverNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService{
    private DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Iterable<Driver> findAll() {
        return this.driverRepository.findAll();
    }

    public Driver findOne(Integer id) throws DriverNotFoundException {
        Driver driver = this.driverRepository.findOne(id);

        if (driver == null) {
            throw new DriverNotFoundException(id);
        }

        return driver;
    }

    public void save(Driver driver) {
        this.driverRepository.save(driver);
    }

    @Override
    public void delete(Integer id) throws DriverNotFoundException {
        Driver driver = this.driverRepository.findOne(id);

        if (driver == null) {
            throw new DriverNotFoundException(id);
        }

        this.driverRepository.delete(id);
    }
}
