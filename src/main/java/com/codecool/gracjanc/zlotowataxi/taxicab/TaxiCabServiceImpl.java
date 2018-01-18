package com.codecool.gracjanc.zlotowataxi.taxicab;

import com.codecool.gracjanc.zlotowataxi.exception.TaxiCabNotFoundException;

public class TaxiCabServiceImpl implements TaxiCabService {
    private TaxiCabRepository taxiCabRepository;

    public TaxiCabServiceImpl(TaxiCabRepository taxiCabRepository) {
        this.taxiCabRepository = taxiCabRepository;
    }

    @Override
    public Iterable<TaxiCab> findAll() {
        return this.taxiCabRepository.findAll();
    }

    @Override
    public TaxiCab findOne(Integer id) throws TaxiCabNotFoundException{
        TaxiCab taxiCab = this.taxiCabRepository.findOne(id);

        if (taxiCab == null) {
            throw new TaxiCabNotFoundException(id);
        }

        return taxiCab;
    }

    @Override
    public void save(TaxiCab driver) {
        this.taxiCabRepository.save(driver);
    }

    @Override
    public void delete(Integer id) {
        TaxiCab taxiCab = this.taxiCabRepository.findOne(id);

        if (taxiCab == null) {
            throw new TaxiCabNotFoundException(id);
        }

        this.taxiCabRepository.delete(id);
    }
}
