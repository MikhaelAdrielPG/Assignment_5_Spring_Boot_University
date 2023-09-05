package com.example.demo.repository;

import com.example.demo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseInterface extends JpaRepository<Course, Long> {
    // CourseInterface adalah sebuah Spring Data JPA repository untuk entitas Course.
    // Ini mengizinkan akses ke operasi dasar CRUD (Create, Read, Update, Delete) pada tabel Course di database.
}
