package com.example.demo.repository;

import com.example.demo.model.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MajorRepository extends JpaRepository<Major, Long> {

    List<Major> findAllByOrderByIdAsc();
}
