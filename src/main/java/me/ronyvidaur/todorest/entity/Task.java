package me.ronyvidaur.todorest.entity;

import javax.persistence.*;

@Entity
@Table(name = "Tasks")
public class Task {

    @Id
    @Column(name = "Id", nullable = false)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "priority", nullable = false)
    private String priority;
    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne(targetEntity = Todo.class)
    @JoinColumn(name="todo_id", nullable=false)
    private Todo todo;

    public Task() {}

    public Task(String name, String priority, String status, long todoId) {
        this.name = name;
        this.priority = priority;
        this.status = status;
        this.todo = new Todo(todoId, "", "");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public String getPriority() {
        return priority;
    }

    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(long id) {
        this.id = id;
    }


}
