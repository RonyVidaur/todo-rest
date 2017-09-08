package me.ronyvidaur.todorest.service;

import me.ronyvidaur.todorest.entity.Todo;
import me.ronyvidaur.todorest.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Transactional(readOnly = true)
    public List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll()
                .forEach(todos::add);
        return todos;
    }

    @Transactional(readOnly = true)
    public Todo getTodo(Long id) {
        return todoRepository.findOne(id);
    }

    @Transactional
    public void addTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Transactional
    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Transactional
    public void deleteTodo(long id) {
        todoRepository.delete(id);
    }
}
