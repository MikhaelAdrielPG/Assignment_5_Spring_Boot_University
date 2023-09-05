package com.example.demo.controller;

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
        return ResponseEntity.status(HttpStatus.OK).body(majorService.majorList());
    }

    // Endpoint untuk mengambil jurusan berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity getMajorById(@PathVariable long id) {
        if (majorService.getMajorById(id) != null) {
            return ResponseEntity.status(HttpStatus.OK).body(majorService.getMajorById(id));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // Endpoint untuk menambahkan jurusan baru
    @PostMapping("")
    public ResponseEntity addMajor(@RequestBody Major major) {
        if (majorService.addMajor(major)) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Major Added Successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to Add Major.");
        }
    }

    // Endpoint untuk memperbarui jurusan berdasarkan ID
    @PutMapping("/{id}")
    public ResponseEntity updateMajor(@PathVariable long id, @RequestBody Major major) {
        if (majorService.updateMajor(id, major)) {
            return ResponseEntity.status(HttpStatus.OK).body("Updated Successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Update Failed.");
        }
    }

    // Endpoint untuk menghapus jurusan berdasarkan ID
    @DeleteMapping("/{id}")
    public ResponseEntity deleteMajor(@PathVariable long id) {
        if (majorService.deleteMajor(id)) {
            return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Delete Failed.");
        }
    }
}