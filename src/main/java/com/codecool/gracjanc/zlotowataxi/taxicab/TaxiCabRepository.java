package com.codecool.gracjanc.zlotowataxi.taxicab;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxiCabRepository extends CrudRepository<TaxiCab, Integer> {
}
