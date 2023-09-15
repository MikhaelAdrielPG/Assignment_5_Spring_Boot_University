package com.example.demo.dto.request;

public class QuizRequest {
    private String name;
    private Integer score;
    private Long studentScoreId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Long getStudentScoreId() {
        return studentScoreId;
    }

    public void setStudentScoreId(Long studentScoreId) {
        this.studentScoreId = studentScoreId;
    }
}
