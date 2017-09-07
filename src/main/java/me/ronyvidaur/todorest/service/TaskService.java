package me.ronyvidaur.todorest.service;

import me.ronyvidaur.todorest.entity.Task;
import me.ronyvidaur.todorest.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TaskService {

    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(long todoId) {

        logger.info("retrieving all task from the todo list with id: %d%n", todoId);
        List<Task> tasks = new ArrayList<>();
        tasks.addAll(taskRepository.findByTodoId(todoId));
        return tasks;
    }

    public Task getTask(long todoId, long id) {
        logger.info("getting task with id:  %d%n", id);
        List<Task> tasks = new ArrayList<>();
        tasks.addAll(taskRepository.findByTodoId(todoId));

        return tasks.stream().filter(t -> t.getId() == id)
                .findFirst()
                .get();

    }

    public void addTask(Task task) {
        logger.info("adding task %s", task);
        taskRepository.save(task);
    }

    public void updateTask(Task task, long id) {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(tasks::add);
        Task newtask = tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst().orElse(null);

        logger.info("updating task %s", task);
        newtask.setName(task.getName());
        newtask.setPriority(task.getPriority());
        newtask.setStatus(task.getStatus());

        taskRepository.save(newtask);
    }

    public void deleteTask(long id) {
        logger.info("deleting task with id: %s", id);
        taskRepository.delete(id);
    }

    public List<Task> geFilteredTask(long todoId, String filter) {
        logger.info("getting tasks by the filter %s", filter);
        List<Task> tasks = new ArrayList<>();
        tasks.addAll(taskRepository.findByTodoId(todoId));
        return tasks.stream()
                .filter(task -> Objects.equals(task.getStatus(), filter))
                .collect(Collectors.toList());
    }

}
