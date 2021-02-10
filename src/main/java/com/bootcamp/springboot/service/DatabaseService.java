package com.bootcamp.springboot.service;

import com.bootcamp.springboot.config.DatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    DatabaseConfig databaseConfig;

    @Autowired
    public DatabaseService(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    public String getDatabaseConnection() {
        // implementation
        return "conn";
    }

    public DatabaseConfig getDatabaseConfig() {
        return this.databaseConfig;
    }


}
