package me.ronyvidaur.todorest.repository;

import me.ronyvidaur.todorest.entity.Todo;
import org.springframework.data.repository.CrudRepository;


public interface TodoRepository extends CrudRepository<Todo, Long> {

}
