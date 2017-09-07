package me.ronyvidaur.todorest.service;

import me.ronyvidaur.todorest.entity.Todo;
import me.ronyvidaur.todorest.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    private final Logger logger = LoggerFactory.getLogger(getClass());


    public List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll()
                .forEach(todos::add);
        logger.info("Getting all Todo Lists");
        return todos;
    }

    public Todo getTodo(Long id) {
        logger.info("Getting todo list with Id: %s", id);
        return todoRepository.findOne(id);
    }

    public void addTodo(Todo todo) {
        logger.info("Adding todo $s", todo);
        todoRepository.save(todo);
    }

    public void updateTodo(Todo todo) {
        logger.info("updating todo %s", todo);
        todoRepository.save(todo);
    }

    public void deleteTodo(long id) {
        logger.info("Deleting todo with id: %s", id);
        todoRepository.delete(id);
    }
}
