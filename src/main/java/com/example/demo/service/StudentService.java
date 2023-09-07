package com.example.demo.service;

import com.example.demo.model.Major;
import com.example.demo.model.Student;
import com.example.demo.repository.MajorRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private MajorRepository majorRepository;

    // Fungsi untuk mendapatkan daftar mahasiswa yang valid
    public List<Student> studentList() {
        List<Student> filteredStudents = new ArrayList<>();

        for (Student student : studentRepository.findAll()) {
            if (student.isExist()) {
                filteredStudents.add(student);
            }
        }

        return filteredStudents;
    }

    // Fungsi untuk mendapatkan mahasiswa berdasarkan NPM
    public Student getStudentByNpm(String npm) {
        Optional<Student> student = studentRepository.findById(npm);

        if (student.isPresent() && student.get().isExist()) {
            return student.get();
        } else {
            return null;
        }
    }

    // Fungsi untuk menambahkan mahasiswa baru jika data valid
    public boolean addStudent(Student student) {
        Optional<Major> major = majorRepository.findById(student.getMajor().getId());

        if (!major.isPresent()) {
            return false;
        } else if (isNameNotValid(student.getName())) {
            return false;
        } else if (isNpmNotValid(student.getNpm())) {
            return false;
        } else {
            student.setMajor(major.get());
            studentRepository.save(student);
            return true;
        }
    }

    // Fungsi untuk memperbarui data mahasiswa berdasarkan NPM
    public boolean updateStudent(String npm, Student student) {
        Optional<Student> studentOptional = studentRepository.findById(npm);

        if (!studentOptional.isPresent()) {
            return false;
        } else if (isNameNotValid(student.getName())) {
            return false;
        } else {
            studentOptional.get().setName(student.getName());
            studentRepository.save(studentOptional.get());
            return true;
        }
    }


    // Fungsi untuk memperbarui status mahasiswa berdasarkan NPM
    public boolean updateActiveStatus(String npm, Student student) {
        Optional<Student> studentOptional = studentRepository.findById(npm);

        if (studentOptional.isPresent()) {
            studentOptional.get().setActive(student.isActive());
            studentRepository.save(studentOptional.get());
            return true;
        } else {
            return false;
        }
    }

    // Fungsi untuk menghapus mahasiswa berdasarkan NPM
    public boolean deleteStudent(String npm) {
        Optional<Student> student = studentRepository.findById(npm);

        if (student.isPresent()) {
            student.get().delete();
            studentRepository.save(student.get());
            return true;
        } else {
            return false;
        }
    }

    // Fungsi utilitas untuk memeriksa validitas NPM
    // NPM dianggap valid jika terdiri dari tepat 10 digit angka
    // Ekspresi regex "\\d{10}" artinya:
    // - "\\d": Cocokkan karakter angka.
    // - "{10}": Pastikan ada tepat 10 karakter angka yang cocok dengan pola ini.
    private boolean isNpmNotValid(String npm) {
        return !npm.matches("\\d{10}");
    }

    // Funsgi utilitas untuk memeriksa validitas nama mahasiswa
    // Nama mahasiswa dianggap valid jika hanya terdiri dari huruf, angka, dan spasi
    // Ekspresi regex "[a-zA-Z0-9\\s]+" artinya:
    // - "[a-zA-Z]": Cocokkan huruf besar atau kecil dari A hingga Z.
    // - "[0-9]": Cocokkan angka dari 0 hingga 9.
    // - "\\s": Cocokkan spasi.
    // "+": Memastikan bahwa satu karakter atau lebih cocok dengan pola ini.
    private boolean isNameNotValid(String name) {
        return !name.matches("[a-zA-Z0-9\\s]+");
    }
}