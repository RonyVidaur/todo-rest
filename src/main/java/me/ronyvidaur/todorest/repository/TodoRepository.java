package me.ronyvidaur.todorest.repository;

import me.ronyvidaur.todorest.entity.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public interface TodoRepository extends CrudRepository<Todo, Long> {

}
