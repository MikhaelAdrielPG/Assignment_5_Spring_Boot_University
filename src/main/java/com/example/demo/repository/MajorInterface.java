package com.example.demo.repository;

import com.example.demo.model.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorInterface extends JpaRepository<Major, Long> {
    // MajorInterface adalah sebuah Spring Data JPA repository untuk entitas Major.
    // Ini mengizinkan akses ke operasi dasar CRUD (Create, Read, Update, Delete) pada tabel Major di database.
}
