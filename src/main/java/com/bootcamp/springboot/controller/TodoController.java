package com.bootcamp.springboot.controller;


import com.bootcamp.springboot.config.DatabaseConfig;
import com.bootcamp.springboot.model.Todo;
import com.bootcamp.springboot.service.DatabaseService;
import com.bootcamp.springboot.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("todo")
public class TodoController {

    TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/list")
    public ResponseEntity<ArrayList<Todo>> List() {
        ArrayList<Todo> result  = this.todoService.getAllTodos();
        return new ResponseEntity<ArrayList<Todo>>(result, HttpStatus.OK);
    }
}
