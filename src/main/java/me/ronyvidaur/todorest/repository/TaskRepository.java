package me.ronyvidaur.todorest.repository;

import me.ronyvidaur.todorest.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@EnableTransactionManagement
public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findByTodoId(long todoId);
}
