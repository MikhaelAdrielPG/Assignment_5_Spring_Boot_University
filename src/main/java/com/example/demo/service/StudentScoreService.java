package com.example.demo.service;

import com.example.demo.model.StudentScore;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentScoreRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentScoreService {
    @Autowired
    private StudentScoreRepository studentScoreRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    // Fungsi untuk mendapatkan daftar nilai mahasiswa
    public List<StudentScore> studentScoreList() {
        return studentScoreRepository.findAll();
    }

    // Fungsi untuk mendapatkan nilai mahasiswa berdasarkan ID
    public StudentScore getStudentScoreById(long id) {
        if (studentScoreRepository.findById(id).orElse(null) != null) {
            return studentScoreRepository.findById(id).orElse(null);
        } else {
            return null;
        }
    }

    // Fungsi untuk mendaftarkan nilai mahasiswa
    public boolean addStudentScore(StudentScore studentScore) {
        if (studentRepository.findById(studentScore.getStudent().getNpm()).orElse(null) == null) {
            return false;
        } else if (courseRepository.findById(studentScore.getCourse().getId()).orElse(null) == null) {
            return false;
        } else {
            studentScore.setStudent(studentRepository.findById(studentScore.getStudent().getNpm()).orElse(null));
            studentScore.setCourse(courseRepository.findById(studentScore.getCourse().getId()).orElse(null));
            studentScoreRepository.save(studentScore);
            return true;
        }
    }

    // Fungsi untuk memperbarui nilai mahasiswa dengan validasi rentang 1-100
    public boolean updateStudentScore(long id, StudentScore studentScore) {
        StudentScore existingStudentScore = studentScoreRepository.findById(id).orElse(null);
        if (existingStudentScore != null) {
            // Validasi rentang nilai 1-100
            if (isScoreInRange(studentScore)) {
                existingStudentScore.setQuiz1(studentScore.getQuiz1());
                existingStudentScore.setQuiz2(studentScore.getQuiz2());
                existingStudentScore.setQuiz3(studentScore.getQuiz3());
                existingStudentScore.setQuiz4(studentScore.getQuiz4());
                existingStudentScore.setQuiz5(studentScore.getQuiz5());
                existingStudentScore.setMidtest(studentScore.getMidtest());
                existingStudentScore.setFinaltest(studentScore.getFinaltest());
                studentScoreRepository.save(existingStudentScore);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // Validasi rentang nilai 1-100
    private boolean isScoreInRange(StudentScore studentScore) {
        int minScore = 0;
        int maxScore = 100;

        return studentScore.getQuiz1() >= minScore && studentScore.getQuiz1() <= maxScore &&
                studentScore.getQuiz2() >= minScore && studentScore.getQuiz2() <= maxScore &&
                studentScore.getQuiz3() >= minScore && studentScore.getQuiz3() <= maxScore &&
                studentScore.getQuiz4() >= minScore && studentScore.getQuiz4() <= maxScore &&
                studentScore.getQuiz5() >= minScore && studentScore.getQuiz5() <= maxScore &&
                studentScore.getMidtest() >= minScore && studentScore.getMidtest() <= maxScore &&
                studentScore.getFinaltest() >= minScore && studentScore.getFinaltest() <= maxScore;
    }
}