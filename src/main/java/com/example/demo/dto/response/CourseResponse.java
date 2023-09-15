package com.example.demo.dto.response;

import com.example.demo.model.Course;

public class CourseResponse {
    private String name;
    private Integer credit;
    private Boolean active;

    public CourseResponse(Course course) {
        this.name = course.getName();
        this.credit = course.getCredit();
        this.active = course.isActive();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
