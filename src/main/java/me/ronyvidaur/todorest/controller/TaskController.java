package me.ronyvidaur.todorest.controller;

import me.ronyvidaur.todorest.entity.Task;
import me.ronyvidaur.todorest.service.TaskService;
import me.ronyvidaur.todorest.util.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


@RequestMapping(value = "todos/{todoId}/")
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity getAllTasks(@PathVariable long todoId, HttpServletRequest request) {
        ResponseBuilder.init();
        ResponseBuilder.setBaseProperties(taskService.getAllTasks(todoId), true, request.getRequestURI());
        return ResponseEntity.ok().body(ResponseBuilder.build());
    }

    @GetMapping(value = "/tasks", params = "filter")
    public ResponseEntity getFilteredTasks(HttpServletRequest request, @PathVariable long todoId, @RequestParam("filter") String filter) {
        ResponseBuilder.init();
        ResponseBuilder.setBaseProperties(
                taskService.geFilteredTask(todoId, filter),
                true,
                request.getRequestURI()
        );
        return ResponseEntity.ok().body(ResponseBuilder.build());
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity getTask(@PathVariable long todoId, @PathVariable long id, HttpServletRequest request) {
        Task task = taskService.getTask(todoId, id);
        ResponseBuilder.init();
        ResponseBuilder.setBaseProperties(task,true, request.getRequestURI());
        return ResponseEntity.ok(ResponseBuilder.build());
    }

    @PostMapping("/tasks")
    public ResponseEntity addTask(@RequestBody Task task, @PathVariable long todoId, HttpServletRequest request) {
        ResponseBuilder.init();
        Task newTask = new Task(task.getName(),task.getPriority(),task.getStatus(), todoId);
        taskService.addTask(newTask);
        ResponseBuilder.setBaseProperties(newTask, true, request.getRequestURI());
        return ResponseEntity.ok().body(ResponseBuilder.build());
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity updateTask(@RequestBody Task task, @PathVariable long id, HttpServletRequest request) {
        task.setId(id);
        ResponseBuilder.init();
        ResponseBuilder.setBaseProperties(task, true, request.getRequestURI());
        taskService.updateTask(task, id);
        return ResponseEntity.ok().body(ResponseBuilder.build());
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity deleteTask(@PathVariable long todoId, @PathVariable long id, HttpServletRequest request) {
        ResponseBuilder.init();
        ResponseBuilder.setBaseProperties(taskService.getTask(todoId, id), true, request.getRequestURI());
        taskService.deleteTask(id);
        return ResponseEntity.ok().body(ResponseBuilder.build());
    }

}
