package com.ali.java.todo.controller;

import com.ali.java.todo.model.Todo;
import com.ali.java.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Profile("dev")
@RequestMapping("/api/v1/todo")
@RequiredArgsConstructor
public class TodoController  {


    private final TodoService todoService;


    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        return new ResponseEntity<>(todoService.save(todo), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        return new ResponseEntity<>(todoService.update(todo), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        return new ResponseEntity<>(todoService.findAll(), HttpStatus.OK);
    }

  @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable Long todoId) {
        return  new ResponseEntity<>(todoService.findById(todoId), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable Long id) {

        return todoService.delete(id);
    }
}
