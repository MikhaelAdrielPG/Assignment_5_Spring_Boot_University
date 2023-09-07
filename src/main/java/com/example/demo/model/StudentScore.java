package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_score")
public class StudentScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "npm", referencedColumnName = "npm")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Course course;
    private Integer quiz1;
    private Integer quiz2;
    private Integer quiz3;
    private Integer quiz4;
    private Integer quiz5;
    private Integer midtest;
    private Integer finaltest;

    public StudentScore() {

    }

    public long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setId(long id) {
        this.id = id;
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