package com.example.demo.dto.request;

public class StudentScoreRequest {
    private String npm;
    private long  courseId;
    private Integer quiz1;
    private Integer quiz2;
    private Integer quiz3;
    private Integer quiz4;
    private Integer quiz5;
    private Integer midtest;
    private Integer finaltest;

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public Integer getQuiz1() {
        return quiz1;
    }

    public void setQuiz1(Integer quiz1) {
        this.quiz1 = quiz1;
    }

    public Integer getQuiz2() {
        return quiz2;
    }

    public void setQuiz2(Integer quiz2) {
        this.quiz2 = quiz2;
    }

    public Integer getQuiz3() {
        return quiz3;
    }

    public void setQuiz3(Integer quiz3) {
        this.quiz3 = quiz3;
    }

    public Integer getQuiz4() {
        return quiz4;
    }

    public void setQuiz4(Integer quiz4) {
        this.quiz4 = quiz4;
    }

    public Integer getQuiz5() {
        return quiz5;
    }

    public void setQuiz5(Integer quiz5) {
        this.quiz5 = quiz5;
    }

    public Integer getMidtest() {
        return midtest;
    }

    public void setMidtest(Integer midtest) {
        this.midtest = midtest;
    }

    public Integer getFinaltest() {
        return finaltest;
    }

    public void setFinaltest(Integer finaltest) {
        this.finaltest = finaltest;
    }
}