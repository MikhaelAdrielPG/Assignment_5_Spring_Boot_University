package com.example.demo.service;

import com.example.demo.model.StudentScore;
import com.example.demo.repository.CourseInterface;
import com.example.demo.repository.StudentScoreInterface;
import com.example.demo.repository.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentScoreService {
    @Autowired
    private StudentScoreInterface studentScoreInterface;
    @Autowired
    private StudentInterface studentInterface;
    @Autowired
    private CourseInterface courseInterface;

    // Fungsi untuk mendapatkan daftar nilai mahasiswa
    public List<StudentScore> studentScoreList() {
        return studentScoreInterface.findAll();
    }

    // Fungsi untuk mendapatkan nilai mahasiswa berdasarkan ID
    public StudentScore getStudentScoreById(long id) {
        if (studentScoreInterface.findById(id).orElse(null) != null) {
            return studentScoreInterface.findById(id).orElse(null);
        } else {
            return null;
        }
    }

    // Fungsi untuk menambahkan nilai mahasiswa
    public boolean addStudentScore(StudentScore studentScore) {
        if (studentInterface.findById(studentScore.getStudent().getNpm()).orElse(null) == null) {
            return false;
        } else if (courseInterface.findById(studentScore.getCourse().getId()).orElse(null) == null) {
            return false;
        } else {
            studentScore.setStudent(studentInterface.findById(studentScore.getStudent().getNpm()).orElse(null));
            studentScore.setCourse(courseInterface.findById(studentScore.getCourse().getId()).orElse(null));
            studentScoreInterface.save(studentScore);
            return true;
        }
    }

    // Fungsi untuk memperbarui nilai mahasiswa
    public boolean updateStudentScore(long id, StudentScore studentScore) {
        if (studentScoreInterface.findById(id).orElse(null) != null) {
            studentScoreInterface.findById(id).orElse(null).setQuiz1(studentScore.getQuiz1());
            studentScoreInterface.findById(id).orElse(null).setQuiz2(studentScore.getQuiz2());
            studentScoreInterface.findById(id).orElse(null).setQuiz3(studentScore.getQuiz3());
            studentScoreInterface.findById(id).orElse(null).setQuiz4(studentScore.getQuiz4());
            studentScoreInterface.findById(id).orElse(null).setQuiz5(studentScore.getQuiz5());
            studentScoreInterface.findById(id).orElse(null).setMidtest(studentScore.getMidtest());
            studentScoreInterface.findById(id).orElse(null).setFinaltest(studentScore.getFinaltest());
            studentScoreInterface.save(studentScoreInterface.findById(id).orElse(null));
            return true;
        } else {
            return false;
        }
    }

    // Fungsi untuk memperbarui status nilai mahasiswa
    public boolean updateStatusStudentScore(long id, StudentScore studentScore) {
        if (studentScoreInterface.findById(id).orElse(null) != null) {
            studentScoreInterface.findById(id).orElse(null).setActive(studentScore.isActive());
            studentScoreInterface.save(studentScoreInterface.findById(id).orElse(null));
            return true;
        } else {
            return false;
        }
    }
}