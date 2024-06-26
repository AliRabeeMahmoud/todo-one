package com.ali.java.todo.controller;


import com.ali.java.todo.model.User;
import com.ali.java.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@Profile("dev")
@RequestMapping("/api/v1/user")
public class UserController  {



    private final UserService userService;



    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }


    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User user) {
        return userService.update(user);
    }


    @GetMapping
    public List<User>getAllUsers() {
        return userService.findAll();
    }


    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.findById(id);
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.delete(id);

    }
}
