package com.example.autofinesdb.repository;

import com.example.autofinesdb.model.Type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepo extends JpaRepository<Type, Integer>
{
}