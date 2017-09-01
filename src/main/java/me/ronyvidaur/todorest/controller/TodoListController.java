package me.ronyvidaur.todorest.controller;


import me.ronyvidaur.todorest.entity.TodoList;
import me.ronyvidaur.todorest.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoListController {

    @Autowired
    TodoListService todoListService;

    @RequestMapping(method = RequestMethod.GET, value = "/lists")
    public List<TodoList> getAllTodos() {
       return todoListService.getAllTodos();
    }

}
