package com.bootcamp.springboot.controller;

import com.bootcamp.springboot.model.Todo;
import com.bootcamp.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }


    // index form
    @RequestMapping("/")
    public String index() {
        return "redirect:/login";
    }

    // Login form
    @RequestMapping("/login")
    public String login(Model model) {
        boolean hasNoUsers = userService.findAll().isEmpty();
        model.addAttribute("hasNoUsers", hasNoUsers);
        return "login";
    }

    // Login form
    @RequestMapping("/login/successfully-created")
    public String loginSuccessfullyCreated(Model model) {
        model.addAttribute("successfullyCreatedUser", true);
        model.addAttribute("hasNoUsers", false);
        return "login";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("hasNoUsers", false);
        return "login";
    }



}