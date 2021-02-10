package com.bootcamp.springboot.service;

import com.bootcamp.springboot.config.DatabaseConfig;
import com.bootcamp.springboot.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class TodoService {

    DatabaseService databaseService;

    @Autowired
    public TodoService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public ArrayList<Todo> getAllTodos() {
        String conn = this.databaseService.getDatabaseConnection();

        //mock select from table
        ArrayList<Todo> list = new ArrayList<>();
        list.add(new Todo(1,"Buy school supplies"));
        list.add(new Todo(2,"Do modules"));
        list.add(new Todo(3,"Get a life"));

        return list;
    }

}
