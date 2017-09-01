package me.ronyvidaur.todorest.repository;

import me.ronyvidaur.todorest.entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {

}
