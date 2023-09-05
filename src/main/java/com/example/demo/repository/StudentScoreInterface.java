package com.example.demo.repository;

import com.example.demo.model.StudentScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentScoreInterface extends JpaRepository<StudentScore, Long> {
    // StudentScoreInterface adalah sebuah Spring Data JPA repository untuk entitas StudentScore.
    // Ini mengizinkan akses ke operasi dasar CRUD (Create, Read, Update, Delete) pada tabel StudentScore di database.
    // ID digunakan sebagai kunci utama (primary key) dalam repository ini.
}
