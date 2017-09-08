package me.ronyvidaur.todorest.service;

import me.ronyvidaur.todorest.entity.Task;
import me.ronyvidaur.todorest.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TaskService {

   @Autowired
    private TaskRepository taskRepository;

    @Transactional(readOnly = true)
    public List<Task> getAllTasks(long todoId) {
        List<Task> tasks = new ArrayList<>();
        tasks.addAll(taskRepository.findByTodoId(todoId));
        return tasks;
    }

    @Transactional(readOnly = true)
    public Task getTask(long todoId, long id) {
        List<Task> tasks = new ArrayList<>();
        tasks.addAll(taskRepository.findByTodoId(todoId));
        return tasks.stream().filter(t -> t.getId() == id)
                .findFirst()
                .get();

    }

    @Transactional
    public void addTask(Task task) {
        taskRepository.save(task);
    }

    @Transactional
    public void updateTask(Task task, long id) {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(tasks::add);
        Task newtask = tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst().orElse(null);

        newtask.setName(task.getName());
        newtask.setPriority(task.getPriority());
        newtask.setStatus(task.getStatus());

        taskRepository.save(newtask);
    }

    @Transactional
    public void deleteTask(long id) {
        taskRepository.delete(id);
    }

    @Transactional(readOnly = true)
    public List<Task> geFilteredTask(long todoId, String filter) {
        List<Task> tasks = new ArrayList<>();
        tasks.addAll(taskRepository.findByTodoId(todoId));
        return tasks.stream()
                .filter(task -> Objects.equals(task.getStatus(), filter))
                .collect(Collectors.toList());
    }

}
