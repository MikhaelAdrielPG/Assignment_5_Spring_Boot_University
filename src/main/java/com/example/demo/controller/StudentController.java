package com.example.demo.controller;

import com.example.demo.model.ApiResponse;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // Endpoint untuk mengambil daftar semua mahasiswa
    @GetMapping("")
    public ResponseEntity getStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.studentList());
    }

    // Endpoint untuk mengambil mahasiswa berdasarkan NPM
    @GetMapping("/{npm}")
    public ResponseEntity getStudentById(@PathVariable String npm) {
        if (studentService.getStudentByNpm(npm) != null) {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentByNpm(npm));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("Failed", "Student Not Found."));
        }
    }

    // Endpoint untuk menambahkan mahasiswa baru
    @PostMapping("")
    public ResponseEntity addStudent(@RequestBody Student student) {
        if (studentService.addStudent(student)) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("Success", "Student Added Successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("Failed", "Failed to Add Student."));
        }
    }

    // Endpoint untuk memperbarui data mahasiswa berdasarkan NPM
    @PutMapping("/{npm}")
    public ResponseEntity updateStudent(@PathVariable String npm, @RequestBody Student student) {
        if (studentService.updateStudent(npm, student)) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("Success", "Student Updated Successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("Failed", "Failed to Update Student."));
        }
    }

    // Endpoint untuk menonaktifkan mahasiswa berdasarkan NPM
    @PatchMapping("/{npm}/deactived")
    public ResponseEntity updateActiveStatus(@PathVariable String npm, @RequestBody Student student) {
        if (studentService.updateActiveStatus(npm, student)) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("Success", "Student NPM " + npm + " is deactived."));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("Failed", "Student NPM " + npm + " not found."));
        }
    }

    // Endpoint untuk menghapus mahasiswa berdasarkan NPM
    @DeleteMapping("/{npm}")
    public ResponseEntity deleteStudent(@PathVariable String npm) {
        if (studentService.deleteStudent(npm)) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("Success", "Student Deleted Successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("Success", "Failed to Delete Student."));
        }
    }
}