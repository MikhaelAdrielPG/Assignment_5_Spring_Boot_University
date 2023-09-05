package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private long id; // ID unik untuk setiap kursus
    private String name; // Nama kursus
    private int credit; // Jumlah kredit yang diberikan untuk kursus
    @Column(name = "is_actived")
    private boolean isActive = true; // Status aktivitas kursus, defaultnya aktif

    @Column(name = "deleted_at")
    private Date deletedAt; // Tanggal ketika kursus dihapus (null jika belum dihapus)

    public Course() {
    }

    // Mendapatkan ID kursus
    public long getId() {
        return id;
    }

    // Mendapatkan nama kursus
    public String getName() {
        return name;
    }

    // Mengatur nama kursus
    public void setName(String name) {
        this.name = name;
    }

    // Mendapatkan jumlah kredit kursus
    public int getCredit() {
        return credit;
    }

    // Mengatur jumlah kredit kursus
    public void setCredit(int credit) {
        this.credit = credit;
    }

    // Mendapatkan status aktivitas kursus
    public boolean isActive() {
        return isActive;
    }

    // Mengatur status aktivitas kursus
    public void setActive(boolean active) {
        isActive = active;
    }

    // Memeriksa apakah kursus ada atau telah dihapus
    @JsonIgnore
    public boolean isExist() {
        return deletedAt == null;
    }

    // Menghapus kursus dengan mengatur tanggal penghapusan
    public void delete() {
        this.deletedAt = new Date();
    }
}
