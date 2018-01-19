package com.codecool.gracjanc.zlotowataxi.driver;

import com.codecool.gracjanc.zlotowataxi.taxicab.TaxiCab;

import javax.persistence.*;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String city;

    @OneToOne(cascade = CascadeType.PERSIST)
    private TaxiCab taxiCab;

    public Driver(String firstName, String lastName, String city, TaxiCab taxiCab) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.taxiCab = taxiCab;
    }

    public Driver() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public TaxiCab getTaxiCab() {
        return taxiCab;
    }

    public void setTaxiCab(TaxiCab taxiCab) {
        this.taxiCab = taxiCab;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
