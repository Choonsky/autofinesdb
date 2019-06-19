package com.example.autofinesdb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.example.autofinesdb.repository")

public class JpaConfig {
    // Default config is OK
}