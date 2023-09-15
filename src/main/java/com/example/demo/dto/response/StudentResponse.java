package com.example.demo.dto.response;

import com.example.demo.model.Student;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentResponse {
    private String name;
    private String npm;
    @JsonProperty("major_name")
    private String majorName;
    private Boolean active;

    public StudentResponse(Student student) {
        this.majorName = student.getMajor().getName();
        this.npm = student.getNpm();
        this.name = student.getName();
        this.active = student.isActive();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }
}
