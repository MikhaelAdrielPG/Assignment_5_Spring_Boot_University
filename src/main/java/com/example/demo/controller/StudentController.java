package com.example.demo.controller;

import com.example.demo.dto.request.StudentRequest;
import com.example.demo.dto.response.StudentResponse;
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

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // Endpoint untuk mengambil daftar semua mahasiswa
    @GetMapping("")
    public ResponseEntity getStudents() {
        List<StudentResponse> students = studentService.studentList().stream().map(
                new Function<Student, StudentResponse>() {
                    @Override
                    public StudentResponse apply(Student student) {
                        return new StudentResponse(student);
                    }
                }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    // Endpoint untuk mengambil mahasiswa berdasarkan NPM
    @GetMapping("/{npm}")
    public ResponseEntity getStudentById(@PathVariable String npm) {
        Student student = studentService.getStudentByNpm(npm);

        if (student != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new StudentResponse(student));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("Failed", "Student Not Found."));
        }
    }

    // Endpoint untuk menambahkan mahasiswa baru
    @PostMapping("")
    public ResponseEntity addStudent(@RequestBody StudentRequest request) {
        if (studentService.addStudent(request)) {
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