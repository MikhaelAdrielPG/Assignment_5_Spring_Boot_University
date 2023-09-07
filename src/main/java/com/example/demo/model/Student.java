package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(length = 10, name = "npm")
    private String npm;
    private String name;
    @ManyToOne
    @JoinColumn(name = "major_id", referencedColumnName = "major_id")
    private Major major;
    @Column(name = "is_actived")
    private boolean isActive = true;
    @Column(name = "deleted_at")
    private Date deletedAt;

    public Student() {

    }

    public String getNpm() {
        return npm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @JsonIgnore
    public boolean isExist() {
        return deletedAt == null;
    }

    public void delete() {
        this.deletedAt = new Date();
    }
}