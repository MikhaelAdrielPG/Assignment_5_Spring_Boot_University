package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(length = 10, name = "npm")
    private String npm; // NPM (Nomor Pokok Mahasiswa) sebagai ID unik untuk setiap mahasiswa, lenghtnya 10
    private String name; // Nama mahasiswa
    @ManyToOne
    @JoinColumn(name = "major_id", referencedColumnName = "major_id")
    private Major major; // Jurusan yang terkait dengan mahasiswa
    @Column(name = "is_actived")
    private boolean isActive = true; // Status aktivitas mahasiswa, defaultnya aktif
    @Column(name = "deleted_at")
    private Date deletedAt; // Tanggal ketika mahasiswa dihapus (null jika belum dihapus)

    public Student() {

    }

    // Mendapatkan NPM mahasiswa
    public String getNpm() {
        return npm;
    }

    // Mendapatkan nama mahasiswa
    public String getName() {
        return name;
    }

    // Mengatur nama mahasiswa dengan menghilangkan spasi di awal dan akhir
    public void setName(String name) {
        this.name = name.trim();
    }

    // Mendapatkan jurusan mahasiswa
    public Major getMajor() {
        return major;
    }

    // Mengatur jurusan mahasiswa
    public void setMajor(Major major) {
        this.major = major;
    }

    // Mendapatkan status aktivitas mahasiswa
    public boolean isActive() {
        return isActive;
    }

    // Mengatur status aktivitas mahasiswa
    public void setActive(boolean active) {
        isActive = active;
    }

    // Memeriksa apakah mahasiswa ada atau telah dihapus
    @JsonIgnore
    public boolean isExist() {
        return deletedAt == null;
    }

    // Menghapus mahasiswa dengan mengatur tanggal penghapusan
    public void delete() {
        this.deletedAt = new Date();
    }
}