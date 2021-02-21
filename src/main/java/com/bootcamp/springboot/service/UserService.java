package com.bootcamp.springboot.service;

import com.bootcamp.springboot.model.Todo;
import com.bootcamp.springboot.model.User;
import com.bootcamp.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findByUsername(String username){
        return  userRepository.findByUsername(username);
    }

    public Optional<User> findById(User user) {
        return userRepository.findById(user.getId());
    }

    public Optional<User> findByIdWOPassword(User user){
        Optional<User> optUser = findById(user);
        optUser.get().setPassword("");
        return optUser;
    }

    public void save(User user) {
        String plainTextPassword = user.getPassword();
        user.setPassword(new BCryptPasswordEncoder().encode(plainTextPassword));
        userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
