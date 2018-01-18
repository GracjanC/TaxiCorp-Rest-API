package com.codecool.gracjanc.zlotowataxi.taxicab;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/taxicabs")
public class TaxiCabController {
    private TaxiCabService taxiCabService;

    public TaxiCabController(TaxiCabService taxiCabService) {
        this.taxiCabService = taxiCabService;
    }

    @GetMapping(path = "")
    public Iterable<TaxiCab> index() {
        return this.taxiCabService.findAll();
    }

    @GetMapping(path = "/{id}")
    public TaxiCab show(@PathVariable Integer id) {
        return this.taxiCabService.findOne(id);
    }

    @PostMapping(path = "")
    public TaxiCab create(@RequestBody TaxiCab taxiCab) {
        this.taxiCabService.save(taxiCab);
        return taxiCab;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        this.taxiCabService.delete(id);
    }
}
