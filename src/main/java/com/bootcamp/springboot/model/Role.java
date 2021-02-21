package com.bootcamp.springboot.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table(name = "tbl_roles", schema = "eisadm")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "roleName")
    private String roleName;
    private String description;

    public Role(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
