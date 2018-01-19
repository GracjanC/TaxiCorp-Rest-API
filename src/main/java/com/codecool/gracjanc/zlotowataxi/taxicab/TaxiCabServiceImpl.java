package com.codecool.gracjanc.zlotowataxi.taxicab;

import com.codecool.gracjanc.zlotowataxi.exception.TaxiCabNotFoundException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class TaxiCabServiceImpl implements TaxiCabService {
    private TaxiCabRepository taxiCabRepository;
    private Logger logger = LogManager.getLogger();

    public TaxiCabServiceImpl(TaxiCabRepository taxiCabRepository) {
        this.taxiCabRepository = taxiCabRepository;
    }

    @Override
    public Iterable<TaxiCab> findAll() {
        logger.log(Level.forName("USAGE", 350), "Retrieve all taxi cabs");
        return this.taxiCabRepository.findAll();
    }

    @Override
    public TaxiCab findOne(Integer id) throws TaxiCabNotFoundException{
        TaxiCab taxiCab = this.taxiCabRepository.findOne(id);

        if (taxiCab == null) {
            throw new TaxiCabNotFoundException(id);
        }
        logger.log(Level.forName("USAGE", 350), "Found taxi cab with id: " + id);
        return taxiCab;
    }

    @Override
    public void save(TaxiCab driver) {
        this.taxiCabRepository.save(driver);
        logger.log(Level.forName("USAGE", 350), "Saved new taxi cab");
    }

    @Override
    public void delete(Integer id) {
        TaxiCab taxiCab = this.taxiCabRepository.findOne(id);

        if (taxiCab == null) {
            throw new TaxiCabNotFoundException(id);
        }

        this.taxiCabRepository.delete(id);
        logger.log(Level.forName("USAGE", 350), "Delete taxi cab with id: " + id);
    }
}
