package com.bootcamp.springboot.service;

import com.bootcamp.springboot.model.Todo;
import com.bootcamp.springboot.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    public static ArrayList<Todo> todoList = new ArrayList<>();

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    public TodoService() {

    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Todo todo) {
        return todoRepository.findById(todo.getId());
    }

    public void setTodoDescription(Todo todo) {
        todoRepository.save(todo);
    }


    public void deleteTodo(Todo todo) {
        todoRepository.delete(todo);
    }


    public void AddNewTodo(Todo todo) {
        todoRepository.save(todo);
    }

}
