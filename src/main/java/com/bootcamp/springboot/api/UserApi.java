package com.bootcamp.springboot.api;

import com.bootcamp.springboot.model.Todo;
import com.bootcamp.springboot.model.User;
import com.bootcamp.springboot.service.TodoService;
import com.bootcamp.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserApi {
    UserService userService;

    @Autowired
    public UserApi(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/list")
    public ResponseEntity List() {
        List<User> userList = this.userService.findAll();
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity List(User user) {
        userService.delete(user);
        return new ResponseEntity(HttpStatus.OK);
    }
}
