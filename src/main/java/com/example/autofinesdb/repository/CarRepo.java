package com.example.autofinesdb.repository;

import com.example.autofinesdb.model.Car;
import com.example.autofinesdb.model.Driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer>
{
    ArrayList<Car> findAllByDriver(Driver driver);
    Car findOneByPlate(String plate);
}