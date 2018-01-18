package com.codecool.gracjanc.zlotowataxi.taxicab;

import com.codecool.gracjanc.zlotowataxi.driver.Driver;

import javax.persistence.*;

@Entity
public class TaxiCab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String make;
    private String model;
    private String licensePlate;

    @OneToOne(mappedBy = "taxiCab", cascade = CascadeType.PERSIST)
    private Driver driver;

    public TaxiCab(String make, String model, String licensePlate, Driver driver) {
        this.make = make;
        this.model = model;
        this.licensePlate = licensePlate;
        this.driver = driver;
    }

    public TaxiCab() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
