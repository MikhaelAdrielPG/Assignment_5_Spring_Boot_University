package com.example.demo.dto.response;

import com.example.demo.model.Major;
import com.example.demo.model.Quiz;

public class QuizResponse {
    private String npm;
    private long  courseId;
    private Integer quiz1;
    private Integer quiz2;
    private Integer quiz3;
    private Integer quiz4;
    private Integer quiz5;
    private Integer midtest;
    private Integer finaltest;
    private String name;
    private Integer score;

    public QuizResponse(Quiz quiz) {
        this.npm =  quiz.getStudentScore().getStudent().getNpm();
        this.courseId = quiz.getStudentScore().getCourse().getId();
        this.quiz1 = quiz.getStudentScore().getQuiz1();
        this.quiz2 = quiz.getStudentScore().getQuiz2();
        this.quiz3 = quiz.getStudentScore().getQuiz3();
        this.quiz4 = quiz.getStudentScore().getQuiz4();
        this.quiz5 = quiz.getStudentScore().getQuiz5();
        this.midtest = quiz.getStudentScore().getMidtest();
        this.finaltest = quiz.getStudentScore().getFinaltest();
        this.name = quiz.getName();
        this.score = quiz.getScore();
    }

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
}
