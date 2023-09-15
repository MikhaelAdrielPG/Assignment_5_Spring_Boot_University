package com.example.demo.service;

import com.example.demo.dto.request.QuizRequest;
import com.example.demo.model.Quiz;
import com.example.demo.model.StudentScore;
import com.example.demo.repository.QuizRepository;
import com.example.demo.repository.StudentScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private StudentScoreRepository studentScoreRepository;

//    public Quiz getQuizById(long id) {
//        Optional<Quiz> quizOptional = quizRepository.findById(id);
//
//        if (quizOptional.isPresent()) {
//            return quizOptional.get();
//        } else {
//            return null;
//        }
//    }

    public List<Quiz> getQuizzesByStudentScoreId(long studentScoreId) {
        return quizRepository.findByStudentScoreId(studentScoreId);
    }


    public boolean addQuiz(QuizRequest request) {
        Optional<Quiz> quizOptional = quizRepository.findFirstByName(request.getName());
        Optional<StudentScore> studentScoreOptional =  studentScoreRepository.findById(request.getStudentScoreId());

        if (!quizOptional.isPresent() && studentScoreOptional.isPresent()) {
            Quiz quiz1 = new Quiz();
            quiz1.setName(request.getName());
            quiz1.setScore(request.getScore());
            quiz1.setStudentScore(studentScoreOptional.get());
            quizRepository.save(quiz1);
            return true;
        } else {
            return false;
        }
    }
}
