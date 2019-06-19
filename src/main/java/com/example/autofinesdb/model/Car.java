package com.example.autofinesdb.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Car.java
 * Model describing Car entity
 * @author Choonsky
 *
 */

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String plate;
    private String type;
    private String model;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Fine> fines;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="driver_id", referencedColumnName="id")
    private Driver driver;

    public Car() {
    }

    public Car(String plate, String type, String model) {
        this.plate = plate;
        this.type = type;
        this.model = model;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Set<Fine> getFines() {
        return fines;
    }

    public void setFines(Set<Fine> fines) {
        this.fines = fines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getId() == car.getId() &&
                getPlate().equals(car.getPlate()) &&
                Objects.equals(getType(), car.getType()) &&
                Objects.equals(getModel(), car.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPlate(), getType(), getModel());
    }
}