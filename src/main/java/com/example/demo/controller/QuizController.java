package com.example.demo.controller;

import com.example.demo.dto.request.QuizRequest;
import com.example.demo.dto.response.MajorResponse;
import com.example.demo.dto.response.QuizResponse;
import com.example.demo.model.ApiResponse;
import com.example.demo.model.Major;
import com.example.demo.model.Quiz;
import com.example.demo.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/quizes")
public class QuizController {

    @Autowired
    private QuizService quizService;

//    @GetMapping("/{id}")
//    public ResponseEntity getQuizById(@PathVariable long id) {
//        if (quizService.getQuizById(id) != null) {
//            return ResponseEntity.status(HttpStatus.OK).body(quizService.getQuizById(id));
//        } else {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Failed", "Quiz Not Found."));
//        }
//    }

    @GetMapping("/scores/{studentScoreId}")
    public ResponseEntity getQuizzesByStudentScoreId(@PathVariable long studentScoreId) {
        List<Quiz> quizzes = quizService.getQuizzesByStudentScoreId(studentScoreId);
        if (!quizzes.isEmpty()) {
            List<QuizResponse> quizes = quizService.getQuizzesByStudentScoreId(studentScoreId).stream().map(
                    new Function<Quiz, QuizResponse>() {
                        @Override
                        public QuizResponse apply(Quiz quiz) {
                            return new QuizResponse(quiz);
                        }
                    }).collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(quizes);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Failed", "Quizzes Not Found."));
        }
    }

    @PostMapping("")
    public ResponseEntity addQuiz(@RequestBody QuizRequest request) {
        if (quizService.addQuiz(request)) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Success", "Quiz Added Successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Failed", "Failed To Add Quiz."));
        }
    }
}
