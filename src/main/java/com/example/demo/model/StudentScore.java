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
@Table(name = "student_course")
public class StudentScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id; // ID unik untuk setiap data skor mahasiswa
    @ManyToOne
    @JoinColumn(name = "npm", referencedColumnName = "npm")
    private Student student; // Mahasiswa yang terkait dengan data skor ini
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Course course; // Kursus yang terkait dengan data skor ini
    private Integer quiz1; // Nilai ujian quiz 1
    private Integer quiz2; // Nilai ujian quiz 2
    private Integer quiz3; // Nilai ujian quiz 3
    private Integer quiz4; // Nilai ujian quiz 4

    private Integer quiz5; // Nilai ujian quiz 5
    private Integer midtest; // Nilai ujian tengah semester
    private Integer finaltest; // Nilai ujian akhir semester
    @Column(name = "is_active")
    private boolean isActive = true; // Status aktivitas data skor, defaultnya aktif

    public StudentScore() {

    }

    // Mendapatkan ID data skor mahasiswa
    public long getId() {
        return id;
    }

    // Mendapatkan mahasiswa terkait dengan data skor ini
    public Student getStudent() {
        return student;
    }

    // Mengatur mahasiswa terkait dengan data skor ini
    public void setStudent(Student student) {
        this.student = student;
    }

    // Mendapatkan kursus terkait dengan data skor ini
    public Course getCourse() {
        return course;
    }

    // Mengatur kursus terkait dengan data skor ini
    public void setCourse(Course course) {
        this.course = course;
    }

    // Mengatur Id
    public void setId(long id) {
        this.id = id;
    }

    // Mendapatkan nilai ujian quiz 1
    public Integer getQuiz1() {
        return quiz1;
    }

    // Mengatur nilai ujian quiz 1
    public void setQuiz1(Integer quiz1) {
        this.quiz1 = quiz1;
    }

    // Mendapatkan nilai ujian quiz 2
    public Integer getQuiz2() {
        return quiz2;
    }

    // Mengatur nilai ujian quiz 2
    public void setQuiz2(Integer quiz2) {
        this.quiz2 = quiz2;
    }

    // Mendapatkan nilai ujian quiz 3
    public Integer getQuiz3() {
        return quiz3;
    }

    // Mengatur nilai ujian quiz 3
    public void setQuiz3(Integer quiz3) {
        this.quiz3 = quiz3;
    }

    // Mendapatkan nilai ujian quiz 4
    public Integer getQuiz4() {
        return quiz4;
    }

    // Mengatur nilai ujian quiz 4
    public void setQuiz4(Integer quiz4) {
        this.quiz4 = quiz4;
    }

    // Mendapatkan nilai ujian quiz 5
    public Integer getQuiz5() {
        return quiz5;
    }

    // Mengatur nilai ujian quiz 5
    public void setQuiz5(Integer quiz5) {
        this.quiz5 = quiz5;
    }

    // Mendapatkan nilai ujian tengah semester
    public Integer getMidtest() {
        return midtest;
    }

    // Mengatur nilai ujian tengah semester
    public void setMidtest(Integer midtest) {
        this.midtest = midtest;
    }

    // Mendapatkan nilai ujian akhir semester
    public Integer getFinaltest() {
        return finaltest;
    }

    // Mengatur nilai ujian akhir semester
    public void setFinaltest(Integer finaltest) {
        this.finaltest = finaltest;
    }

    // Mendapatkan status aktivitas data skor
    public boolean isActive() {
        return isActive;
    }

    // Mengatur status aktivitas data skor
    public void setActive(boolean active) {
        isActive = active;
    }
}