package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "major")
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "major_id")
    private long id; // ID unik untuk setiap jurusan
    private String name; // Nama jurusan

    @Column(name = "deleted_at")
    private Date deletedAt; // Tanggal ketika jurusan dihapus (null jika belum dihapus)

    @JsonIgnore
    @OneToMany(mappedBy = "major")
    private List<Student> studentList; // Daftar mahasiswa yang terdaftar dalam jurusan ini

    public Major() {
    }

    // Mendapatkan ID jurusan
    public long getId() {
        return id;
    }

    // Mendapatkan nama jurusan
    public String getName() {
        return name;
    }

    // Mengatur nama jurusan dengan menghilangkan spasi di awal dan akhir
    public void setName(String name) {
        this.name = name.trim();
    }

    // Memeriksa apakah jurusan ada atau telah dihapus
    @JsonIgnore
    public boolean isExist() {
        return deletedAt == null; // Entitas dianggap ada jika deletedAt adalah null
    }

    // Menghapus jurusan dengan mengatur tanggal penghapusan
    public void delete() {
        this.deletedAt = new Date(); // Menetapkan deletedAt saat menghapus
    }
}