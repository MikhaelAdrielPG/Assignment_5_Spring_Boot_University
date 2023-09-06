package com.example.demo.controller;

import com.example.demo.model.ApiResponse;
import com.example.demo.model.StudentScore;
import com.example.demo.service.StudentScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-scores")
public class StudentScoreController {
    @Autowired
    private StudentScoreService studentScoreService;

    // Endpoint daftar semua skor siswa
    @GetMapping("")
    public ResponseEntity getStudentScores() {
        List<StudentScore> studentScores = studentScoreService.studentScoreList();
        return ResponseEntity.status(HttpStatus.OK).body(studentScores);
    }

    // Endpoint skor siswa berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity getStudentScoreById(@PathVariable long id) {
        StudentScore studentScore = studentScoreService.getStudentScoreById(id);
        if (studentScore != null) {
            return ResponseEntity.status(HttpStatus.OK).body(studentScore);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse("Failed", "Student Score Not Found."));
        }
    }

    // Endpoint Menambahkan skor siswa baru
    @PostMapping("")
    public ResponseEntity registerStudentScore(@RequestBody StudentScore studentScore) {
        if (studentScoreService.addStudentScore(studentScore)) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse("Success", "Student Score Added Successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("Failed", "Failed to Add Student Score."));
        }
    }

    // Endpoint memperbarui data skor siswa berdasarkan ID
    @PutMapping("/{id}")
    public ResponseEntity updateStudentScore(@PathVariable long id, @RequestBody StudentScore studentScore) {
        if (studentScoreService.updateStudentScore(id, studentScore)) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("Success", "Student Score Updated Successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("Failed", "Failed to Update Student Score."));
        }
    }
}