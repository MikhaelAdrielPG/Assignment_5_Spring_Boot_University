package com.example.demo.controller;

import com.example.demo.model.ApiResponse;
import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
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
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    // Endpoint untuk mengambil daftar semua kursus
    @GetMapping("")
    public ResponseEntity getCourses() {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.courseList());
    }

    // Endpoint untuk mengambil kursus berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity getCourseById(@PathVariable long id) {
        if (courseService.getCourseById(id) != null) {
            return ResponseEntity.status(HttpStatus.OK).body(courseService.getCourseById(id));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("Failed", "Course Not Found."));
        }
    }

    // Endpoint untuk menambahkan kursus baru
    @PostMapping("")
    public ResponseEntity addCourse(@RequestBody Course course) {
        if (courseService.addCourse(course)) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("Success", "Course Added Successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("Success", "Failed to Added Course."));
        }
    }

    // Endpoint untuk memperbarui kursus berdasarkan ID
    @PutMapping("/{id}")
    public ResponseEntity updateCourse(@PathVariable long id, @RequestBody Course course) {
        if (courseService.updateCourse(id,course)) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("Success", "Course Updated Successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("Failed", "Failed to Update Course."));
        }
    }

    // Endpoint untuk menonaktifkan kursus berdasarkan ID
    @PatchMapping("/{id}/deactived")
    public ResponseEntity updateActiveStatus(@PathVariable long id, @RequestBody Course course) {
        if (courseService.updateStatus(id,course)) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("Success", "Course ID " + id + " is deactived."));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("Failed", "Course ID " + id + " not found."));
        }
    }

    // Endpoint untuk menghapus kursus berdasarkan ID
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCourse(@PathVariable long id) {
        if (courseService.deleteCourse(id)) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("Success", "Course Deleted Successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("Failed", "Failed to Delete Course."));
        }
    }
}