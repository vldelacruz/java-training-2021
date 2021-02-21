package com.bootcamp.springboot.model;


import javax.persistence.*;

@Entity
@Table(name = "tbl_todo", schema = "eisadm")
public class Todo {

    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    public Todo() {}

    public Todo(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id   ;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
