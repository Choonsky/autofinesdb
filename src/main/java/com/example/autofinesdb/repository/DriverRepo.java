package com.example.autofinesdb.repository;

import com.example.autofinesdb.model.Driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepo extends JpaRepository<Driver, Integer>
{
    Driver findOneByFullname(String fullname);
}