package com.example.autofinesdb.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * Fine.java
 * Model describing Fine entity
 * @author Choonsky
 *
 */

@Entity
@Table(name = "fines")
public class Fine {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private LocalDate date;
    private Integer sum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="car_id", referencedColumnName="id")
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="type_id", referencedColumnName="id")
    private Type type;

    public Fine() {
    }

    public Fine(LocalDate date, Integer sum, Type type) {
        this.date = date;
        this.sum = sum;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fine fine = (Fine) o;
        return getId() == fine.getId() &&
                getSum().equals(fine.getSum()) &&
                getCar().equals(fine.getCar());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSum(), getCar());
    }
}