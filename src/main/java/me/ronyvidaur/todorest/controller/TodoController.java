package me.ronyvidaur.todorest.controller;


import me.ronyvidaur.todorest.entity.Todo;
import me.ronyvidaur.todorest.service.TodoService;
import me.ronyvidaur.todorest.util.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;


@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public ResponseEntity getAllTodos(HttpServletRequest request) {
        ResponseBuilder.init();
        ResponseBuilder.setBaseProperties(todoService.getAllTodos(), true, request.getRequestURI());
        return ResponseEntity.ok().body(ResponseBuilder.build());
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity getTodoListById(@PathVariable long id, HttpServletRequest request) {
        Todo todo = todoService.getTodo(id);
        ResponseBuilder.init();
        ResponseBuilder.setBaseProperties(todo, true, request.getRequestURI());
        if (todo == null) {
            throw new NoSuchElementException();
        }
        return ResponseEntity.ok().body(ResponseBuilder.build());
    }

    @PostMapping("/todos")
    public ResponseEntity addTodo(@RequestBody Todo todo, HttpServletRequest request) {
        ResponseBuilder.init();
        ResponseBuilder.setBaseProperties(todo, true, request.getRequestURI());
        todoService.addTodo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseBuilder.build());
    }

    @PutMapping("/todos/{id}")
    public void updateTodo(@RequestBody Todo todo) {
        todoService.updateTodo(todo);
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity deleteTodo(@PathVariable long id, HttpServletRequest request) {
        ResponseBuilder.init();
        ResponseBuilder.setBaseProperties(todoService.getTodo(id), true, request.getRequestURI());
        todoService.deleteTodo(id);
        return ResponseEntity.ok().body(ResponseBuilder.build());
    }

}
