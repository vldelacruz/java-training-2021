package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.model.Todo;
import com.bootcamp.springboot.model.User;
import com.bootcamp.springboot.service.TodoService;
import com.bootcamp.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String List(Model model) {
        return "user-list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user",new User());
        model.addAttribute("action","create");
        return "user-create";
    }


    @GetMapping("/edit")
    public String edit(@ModelAttribute User user,Model model) {
        model.addAttribute("user",userService.findById(user));
        model.addAttribute("action","create");
        return "user-create";
    }



    @PostMapping("/add-user")
    public String add(@ModelAttribute User user, Model model) {
        userService.save(user);
        return "redirect:/users/list";
    }

    @PostMapping("/add-initial-user")
    public String addInitialUser(@ModelAttribute User user, Model model) {
        user.setActive(true);
        userService.save(user);
        return "redirect:/login/successfully-created";
    }

    @PostMapping("/edit-user")
    public String editUser(@ModelAttribute User user, Model model) {
        userService.save(user);
        return "redirect:/users/list";
    }



}
