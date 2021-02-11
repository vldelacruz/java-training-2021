package com.bootcamp.springboot.controller;


import com.bootcamp.springboot.model.Todo;
import com.bootcamp.springboot.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("todo")
public class TodoController {

    TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/list")
    public String List(Model model) {
        model.addAttribute("todoList",this.todoService.getAllTodos());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("todo",new Todo());
        model.addAttribute("action","create");
        return "create";
    }

    @GetMapping("/edit")
    public String update(@ModelAttribute Todo todo,Model model) {
        model.addAttribute("todo",todoService.getTodoById(todo));
        model.addAttribute("action","edit");
        return "create";
    }



    @PostMapping("/add-todo")
    public String add(@ModelAttribute Todo todo,Model model) {
        todoService.AddNewTodo(todo);
        return "redirect:/todo/list";
    }

    @PostMapping("/edit-todo")
    public String editTodo(@ModelAttribute Todo todo,Model model) {
        todoService.setTodoDescription(todo);
        return "redirect:/todo/list";
    }

    @GetMapping("/delete-todo")
    public String delete(@ModelAttribute Todo todo,Model model) {
        todoService.deleteTodo(todo);
        return "redirect:/todo/list";
    }
}
