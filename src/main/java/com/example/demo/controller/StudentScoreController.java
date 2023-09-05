package com.example.demo.controller;

import com.example.demo.model.StudentScore;
import com.example.demo.service.StudentScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student-scores")
public class StudentScoreController {
    @Autowired
    private StudentScoreService studentScoreService;

    // Endpoint daftar semua skor siswa
    @GetMapping("")
    public ResponseEntity getStudentScore() {
        return ResponseEntity.status(HttpStatus.OK).body(studentScoreService.studentScoreList());
    }

    // Endpoint skor siswa berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity getStudentScoreById(@PathVariable int id) {
        if (studentScoreService.getStudentScoreById(id) != null) {
            return ResponseEntity.status(HttpStatus.OK).body(studentScoreService.getStudentScoreById(id));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student Score Not Found.");
        }
    }

    // Endpoint Menambahkan skor siswa baru
    @PostMapping("")
    public ResponseEntity addStudentScore(@RequestBody StudentScore studentScore) {
        if (studentScoreService.addStudentScore(studentScore)) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Student Score Added Successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed Add Student Score.");
        }
    }

    // Endpoint memperbarui data skor siswa berdasarkan ID
    @PutMapping("/grade/{id}")
    public ResponseEntity updateDataStudentScore(@PathVariable int id, @RequestBody StudentScore studentScore) {
        if (studentScoreService.updateStudentScore(id, studentScore)) {
            return ResponseEntity.status(HttpStatus.OK).body("Updated Successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Update Failed.");
        }
    }

    // Endpoint mengubah status skor siswa menjadi tidak aktif
    @PatchMapping("/{id}/deactived")
    public ResponseEntity updateActiveStudentScore(@PathVariable int id, @RequestBody StudentScore studentScore) {
        if (studentScoreService.updateStatusStudentScore(id, studentScore)) {
            return ResponseEntity.status(HttpStatus.OK).body("Student Score ID " + id + " is deactived.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student Score ID " + id + " is active.");
        }
    }
}