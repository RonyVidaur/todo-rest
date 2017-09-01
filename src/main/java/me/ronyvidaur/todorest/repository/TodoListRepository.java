package me.ronyvidaur.todorest.repository;

import me.ronyvidaur.todorest.entity.TodoList;
import org.springframework.data.repository.CrudRepository;


public interface TodoListRepository extends CrudRepository<TodoList, Long> {

}
