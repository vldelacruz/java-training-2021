package com.bootcamp.springboot.service;

import com.bootcamp.springboot.config.DatabaseConfig;
import com.bootcamp.springboot.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class TodoService {

    public static ArrayList<Todo> todoList = new ArrayList<>();
    DatabaseService databaseService;

    @Autowired
    public TodoService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public ArrayList<Todo> getAllTodos() {
        String conn = this.databaseService.getDatabaseConnection();
        return todoList;
    }

    public Todo getTodoById(Todo todo) {
        for (Todo item : todoList) {
            if (item.getId() == todo.getId()) {
                return item;
            }
        }
        return todo;
    }

    public void setTodoDescription(Todo todo) {
        for (Todo item : todoList) {
            if (item.getId() == todo.getId()) {
                item.setDescription(todo.getDescription());
            }
        }
    }


    public void deleteTodo(Todo todo) {
        Todo todo1 = new Todo();
        for (Todo item : todoList) {
            if (item.getId() == todo.getId()) {
                todo1 = item;
            }
        }
        todoList.remove(todo1);
    }


    public void AddNewTodo(Todo todo) {

        if (todoList.size() == 0) {
            todo.setId(1);
        } else {
            todo.setId(todoList.get(todoList.size() - 1).getId() + 1);
        }
        todoList.add(todo);
    }

}
