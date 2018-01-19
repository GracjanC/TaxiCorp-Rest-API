package com.codecool.gracjanc.zlotowataxi.driver;

import com.codecool.gracjanc.zlotowataxi.exception.DriverNotFoundException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService{
    private DriverRepository driverRepository;
    private Logger logger = LogManager.getLogger();

    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Iterable<Driver> findAll() {
        logger.log(Level.forName("USAGE", 350), "Retrieve all drivers");
        return this.driverRepository.findAll();
    }

    public Driver findOne(Integer id) throws DriverNotFoundException {
        Driver driver = this.driverRepository.findOne(id);

        if (driver == null) {
            throw new DriverNotFoundException(id);
        }
        logger.log(Level.forName("USAGE", 350), "Found driver with id: " + id);
        return driver;
    }

    public void save(Driver driver) {
        this.driverRepository.save(driver);
        logger.log(Level.forName("USAGE", 350), "Saved new driver");
    }

    @Override
    public void delete(Integer id) throws DriverNotFoundException {
        Driver driver = this.driverRepository.findOne(id);

        if (driver == null) {
            throw new DriverNotFoundException(id);
        }

        this.driverRepository.delete(id);
//        logger.info("Delete object with id: " + id);
        logger.log(Level.forName("USAGE", 350), "Delete driver with id: " + id);
    }

}
