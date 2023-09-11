package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.model.StudentScore;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentScoreRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<StudentScore> studentScore = studentScoreRepository.findById(id);

        return studentScore.orElse(null);
    }

    // Fungsi untuk menambahkan nilai mahasiswa
    public boolean addStudentScore(StudentScore studentScore) {
        Optional<Student> student = studentRepository.findById(studentScore.getStudent().getNpm());
        Optional<Course> course = courseRepository.findById(studentScore.getCourse().getId());

        if (!student.isPresent()) {
            return false;
        } else if (!course.isPresent()) {
            return false;
        } else {
            studentScore.setStudent(student.get());
            studentScore.setCourse(course.get());
            studentScoreRepository.save(studentScore);
            return true;
        }
    }

    // Fungsi untuk memperbarui nilai mahasiswa
    public boolean updateStudentScore(long id, StudentScore studentScore) {
        Optional<StudentScore> score = studentScoreRepository.findById(id);

        if (score.isPresent()) {
            score.get().setQuiz1(studentScore.getQuiz1());
            score.get().setQuiz2(studentScore.getQuiz2());
            score.get().setQuiz3(studentScore.getQuiz3());
            score.get().setQuiz4(studentScore.getQuiz4());
            score.get().setQuiz5(studentScore.getQuiz5());
            score.get().setMidtest(studentScore.getMidtest());
            score.get().setFinaltest(studentScore.getFinaltest());
            studentScoreRepository.save(score.get());
            return true;
        } else {
            return false;
        }
    }
}