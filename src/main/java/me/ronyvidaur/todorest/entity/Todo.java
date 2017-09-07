package me.ronyvidaur.todorest.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Todos")
public class Todo {

    @Id
    @Column(name = "Id", nullable = false)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "todo", targetEntity = Task.class)
    private List<Task> taks = new ArrayList<>();

    public Todo() {}

    public Todo(long id,String name, String description) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Task> getTaks() {
        return taks;
    }

    public long getId() {
        return id;
    }
}
