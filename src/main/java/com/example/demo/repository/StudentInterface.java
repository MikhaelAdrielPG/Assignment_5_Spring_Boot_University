package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentInterface extends JpaRepository<Student, String> {
    // StudentInterface adalah sebuah Spring Data JPA repository untuk entitas Student.
    // Ini mengizinkan akses ke operasi dasar CRUD (Create, Read, Update, Delete) pada tabel Student di database.
    // NPM (Nomor Pokok Mahasiswa) digunakan sebagai kunci utama (primary key) dalam repository ini.
}
