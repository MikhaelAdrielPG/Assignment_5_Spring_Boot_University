package com.example.demo.controller;

import com.example.demo.model.ApiResponse;
import com.example.demo.model.Major;
import com.example.demo.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/majors")
public class MajorController {
    @Autowired
    private MajorService majorService;

    // Endpoint untuk mengambil daftar semua jurusan
    @GetMapping("")
    public ResponseEntity getMajors() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(majorService.majorList());
    }

    // Endpoint untuk mengambil jurusan berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity getMajorById(@PathVariable long id) {
        Major major = majorService.getMajorById(id);

        if (major != null) {
            return ResponseEntity.status(HttpStatus.OK).body(major);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("Failed", "Major Not Found."));
        }
    }

    // Endpoint untuk menambahkan jurusan baru
    @PostMapping("")
    public ResponseEntity addMajor(@RequestBody Major major) {
        if (majorService.addMajor(major)) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("Success", "Major Added Successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("Failed", "Failed to Add Major."));
        }
    }

    // Endpoint untuk memperbarui jurusan berdasarkan ID
    @PutMapping("/{id}")
    public ResponseEntity updateMajor(@PathVariable long id, @RequestBody Major major) {
        if (majorService.updateMajor(id, major)) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("Success", "Major Updated Successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("Failed", "Failed to Update Major."));
        }
    }

    // Endpoint untuk menghapus jurusan berdasarkan ID
    @DeleteMapping("/{id}")
    public ResponseEntity deleteMajor(@PathVariable long id) {
        if (majorService.deleteMajor(id)) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("Success", "Major Deleted Successfully."));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("Failed", "Failed to Delete Major."));
        }
    }
}