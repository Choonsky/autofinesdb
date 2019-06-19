package com.example.autofinesdb.repository;

import com.example.autofinesdb.model.Car;
import com.example.autofinesdb.model.Fine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface FineRepo extends JpaRepository<Fine, Integer>
{
    ArrayList<Fine> findAllByCar(Car car);
}