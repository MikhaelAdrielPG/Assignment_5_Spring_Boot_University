package com.example.demo.dto.response;

import com.example.demo.model.StudentScore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentScoreResponse {
    private String npm;
    @JsonProperty("student_name")
    private String studentName;
    @JsonProperty("major_name")
    private String majorName;
    @JsonProperty("course_name")
    private String courseName;
    private Integer credit;
    @JsonProperty("quiz_1")
    private Integer quiz1;
    @JsonProperty("quiz_2")
    private Integer quiz2;
    @JsonProperty("quiz_3")
    private Integer quiz3;
    @JsonProperty("quiz_4")
    private Integer quiz4;
    @JsonProperty("quiz_5")
    private Integer quiz5;
    @JsonProperty("mid_test")
    private Integer midtest;
    @JsonProperty("final_test")
    private Integer finaltest;

    public StudentScoreResponse(StudentScore studentScore) {
        this.npm =  studentScore.getStudent().getNpm();
        this.studentName = studentScore.getStudent().getName();
        this.majorName = studentScore.getStudent().getMajor().getName();
        this.courseName = studentScore.getCourse().getName();
        this.credit = studentScore.getCourse().getCredit();
        this.quiz1 = studentScore.getQuiz1();
        this.quiz2 = studentScore.getQuiz2();
        this.quiz3 = studentScore.getQuiz3();
        this.quiz4 = studentScore.getQuiz4();
        this.quiz5 = studentScore.getQuiz5();
        this.midtest = studentScore.getMidtest();
        this.finaltest = studentScore.getFinaltest();
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
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
