package com.example.autofinesdb.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Driver.java
 * Model describing Driver entity
 * @author Choonsky
 *
 */

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String passport;
    private String fullname;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Car> cars;

    public Driver() {
    }

    public Driver(String passport, String fullname) {
        this.passport = passport;
        this.fullname = fullname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return getId() == driver.getId() &&
                getPassport().equals(driver.getPassport());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPassport());
    }
}