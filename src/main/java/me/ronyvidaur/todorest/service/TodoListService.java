package me.ronyvidaur.todorest.service;

import me.ronyvidaur.todorest.entity.TodoList;
import me.ronyvidaur.todorest.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoListService {

    @Autowired
    TodoListRepository todoListRepository;


    public List<TodoList> getAllTodos() {
        List<TodoList> todos = new ArrayList<>();
        todoListRepository.findAll()
                .forEach(todos::add);
        return todos;
    }
}
