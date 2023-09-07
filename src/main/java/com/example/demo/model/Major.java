package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "major")
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "major_id")
    private long id;
    private String name;

    @Column(name = "deleted_at")
    private Date deletedAt;

    @JsonIgnore
    @OneToMany(mappedBy = "major")
    private List<Student> studentList;

    public Major() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    @JsonIgnore
    public boolean isExist() {
        return deletedAt == null;
    }

    public void delete() {
        this.deletedAt = new Date();
    }
}