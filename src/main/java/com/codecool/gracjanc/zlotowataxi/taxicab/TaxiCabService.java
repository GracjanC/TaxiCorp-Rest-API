package com.codecool.gracjanc.zlotowataxi.taxicab;

import org.springframework.stereotype.Service;

@Service
public interface TaxiCabService {
    Iterable<TaxiCab> findAll();

    TaxiCab findOne(Integer id);

    void save(TaxiCab driver);

    void delete(Integer id);
}
