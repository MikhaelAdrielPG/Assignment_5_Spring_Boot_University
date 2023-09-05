package com.example.demo.service;

import com.example.demo.model.Major;
import com.example.demo.repository.MajorInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MajorService {
    @Autowired
    private MajorInterface majorInterface;

    // Fungsi untuk mendapatkan daftar jurusan yang valid
    public List<Major> majorList() {
        List<Major> filteredMajors = new ArrayList<>();

        for (Major major : majorInterface.findAll()) {
            if (major.isExist()) {
                filteredMajors.add(major);
            }
        }

        return filteredMajors;
    }

    // Fungsi untuk mendapatkan jurusan berdasarkan ID
    public Major getMajorById(long id) {
        if (majorInterface.findById(id).orElse(null) != null
                && majorInterface.findById(id).orElse(null).isExist()) {
            return majorInterface.findById(id).orElse(null);
        } else {
            return null;
        }
    }

    // Fungsi untuk menambahkan jurusan baru jika nama valid
    public boolean addMajor(Major major) {
        if (isNameValid(major.getName())) {
            majorInterface.save(major);
            return true;
        } else {
            return false;
        }
    }

    // Fungsi untuk memperbarui jurusan berdasarkan ID
    public boolean updateMajor(Long id, Major major) {
        if (getMajorById(id) != null || isNameValid(major.getName())) {
            getMajorById(id).setName(major.getName());
            majorInterface.save(getMajorById(id));
            return true;
        } else {
            return false;
        }
    }

    // Fungsi untuk menghapus jurusan berdasarkan ID
    public boolean deleteMajor(Long id) {
        if (majorInterface.findById(id).orElse(null) != null) {
            majorInterface.findById(id).orElse(null).delete();
            majorInterface.save(majorInterface.findById(id).orElse(null));
            return true;
        } else {
            return false;
        }
    }

    // Fungsi utilitas untuk memeriksa validitas nama jurusan
    // Nama jurusan dianggap valid jika hanya terdiri dari huruf, angka, dan spasi
    // [a-zA-Z0-9\\s]+ artinya:
    // - [a-zA-Z]: Cocokkan huruf besar atau kecil dari A hingga Z.
    // - [0-9]: Cocokkan angka dari 0 hingga 9.
    // - \\s: Cocokkan spasi.
    // +: Memastikan bahwa satu karakter atau lebih cocok dengan pola yang diberikan.
    private boolean isNameValid(String name) {
        return name.matches("[a-zA-Z0-9\\s]+");
    }
}