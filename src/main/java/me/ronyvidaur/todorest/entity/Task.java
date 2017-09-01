package me.ronyvidaur.todorest.entity;

import javax.persistence.*;

@Entity
public class Task {



    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String name;
    private boolean isComplete;

    @ManyToOne
    private TodoList todoList;


    public Task() {}

    public Task(String name, boolean isComplete) {
        this.name = name;
        this.isComplete = isComplete;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public String getName() {
        return name;
    }

    public boolean isComplete() {
        return isComplete;
    }
}
