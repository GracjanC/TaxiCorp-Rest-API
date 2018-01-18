package com.codecool.gracjanc.zlotowataxi.driver;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/drivers")
public class DriverController {

    private DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping(path = "")
    public Iterable<Driver> index() {
        return this.driverService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Driver show(@PathVariable Integer id) {
        return this.driverService.findOne(id);
    }

    @PostMapping(path = "")
    public Driver create(@RequestBody Driver driver) {
        this.driverService.save(driver);
    return driver;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        this.driverService.delete(id);
    }
}
