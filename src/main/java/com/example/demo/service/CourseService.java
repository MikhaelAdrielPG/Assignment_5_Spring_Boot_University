package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    // Fungsi untuk mendapatkan daftar kursus yang valid
    public List<Course> courseList() {
        List<Course> validCourses = new ArrayList<>();

        for (Course course : courseRepository.findAll()) {
            if (course.isExist()) {
                validCourses.add(course);
            }
        }

        return validCourses;
    }

    // Fungsi untuk mendapatkan kursus berdasarkan ID
    public Course getCourseById(long id) {
        if (courseRepository.findById(id).orElse(null) != null
                && courseRepository.findById(id).orElse(null).isExist()) {
            return courseRepository.findById(id).orElse(null);
        } else {
            return null;
        }
    }

    // Fungsi untuk menambahkan kursus baru jika nama valid dan kredit lebih dari 0
    public boolean addCourse(Course course) {
        if (isNameValid(course.getName()) && course.getCredit() > 0) {
            courseRepository.save(course);
            return true;
        } else {
            return false;
        }
    }

    // Fungsi untuk memperbarui kursus berdasarkan ID
    public boolean updateCourse(Long id, Course course) {
         if (courseRepository.findById(id).orElse(null) == null
                 && !isNameValid(course.getName()) || course.getCredit() <= 0) {
            return false;
        } else {
            courseRepository.findById(id).orElse(null).setName(course.getName());
            courseRepository.findById(id).orElse(null).setCredit(course.getCredit());
            courseRepository.save(courseRepository.findById(id).orElse(null));
            return true;
        }
    }

    // Fungsi untuk memperbarui status kursus berdasarkan ID
    public boolean updateStatus(long id, Course course) {
        if (courseRepository.findById(id).orElse(null) != null) {
            courseRepository.findById(id).orElse(null).setActive(course.isActive());
            courseRepository.save(courseRepository.findById(id).orElse(null));
            return true;
        } else {
            return false;
        }
    }

    // Fungsi untuk menghapus kursus berdasarkan ID
    public boolean deleteCourse(Long id) {
        if (courseRepository.findById(id).orElse(null) != null) {
            courseRepository.findById(id).orElse(null).delete();
            courseRepository.save(courseRepository.findById(id).orElse(null));
            return true;
        } else {
            return false;
        }
    }

    // Fungsi utilitas untuk memeriksa validitas nama kursus
    // Nama kursus dianggap valid jika hanya terdiri dari huruf, angka, dan spasi
    // [a-zA-Z0-9\\s]+ artinya:
    // - [a-zA-Z]: Cocokkan huruf besar atau kecil dari A hingga Z.
    // - [0-9]: Cocokkan angka dari 0 hingga 9.
    // - \\s: Cocokkan spasi.
    // +: Memastikan bahwa satu karakter atau lebih cocok dengan pola yang diberikan.
    private boolean isNameValid(String name) {
        return name.matches("[a-zA-Z0-9\\s]+");
    }
}