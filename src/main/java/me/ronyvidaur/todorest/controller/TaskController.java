package me.ronyvidaur.todorest.controller;

import me.ronyvidaur.todorest.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;
}
