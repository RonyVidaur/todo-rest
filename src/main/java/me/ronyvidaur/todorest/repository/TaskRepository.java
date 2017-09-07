package me.ronyvidaur.todorest.repository;

import me.ronyvidaur.todorest.entity.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findByTodoId(long todoId);
}
