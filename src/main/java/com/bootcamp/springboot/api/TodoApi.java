package com.bootcamp.springboot.api;


import com.bootcamp.springboot.model.Todo;
import com.bootcamp.springboot.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/todo")
public class TodoApi {

    TodoService todoService;

    @Autowired
    public TodoApi(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping("/list")
    public ResponseEntity List() {
        List<Todo> todoList = this.todoService.getAllTodos();
        return new ResponseEntity<List<Todo>>(todoList, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity List(Todo todo) {
        todoService.deleteTodo(todo);
        return new ResponseEntity(HttpStatus.OK);
    }
}
