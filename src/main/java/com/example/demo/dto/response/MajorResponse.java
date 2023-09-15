package com.example.demo.dto.response;

import com.example.demo.model.Major;

public class MajorResponse {
    private String name;

    public MajorResponse(Major major) {
        this.name = major.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
