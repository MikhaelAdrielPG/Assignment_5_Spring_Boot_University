package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<Course> course = courseRepository.findById(id);

        return course.orElse(null);
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
        Optional<Course> courseOptional = courseRepository.findById(id);

        if (courseOptional.isPresent() && isNameValid(course.getName()) && course.getCredit() > 0) {
            Course existingCourse = courseOptional.get();
            existingCourse.setName(course.getName());
            existingCourse.setCredit(course.getCredit());
            courseRepository.save(existingCourse);
            return true;
        } else {

        return false;
        }
    }


    // Fungsi untuk memperbarui status kursus berdasarkan ID
    public boolean updateStatus(long id, Course course) {
        Optional<Course> courseOptional = courseRepository.findById(id);

        if (courseOptional.isPresent()) {
            courseOptional.get().setActive(course.isActive());
            courseRepository.save(courseOptional.get());
            return true;
        } else {
            return false;
        }
    }

    // Fungsi untuk menghapus kursus berdasarkan ID
    public boolean deleteCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);

        if (course.isPresent()) {
            course.get().delete();
            courseRepository.save(course.get());
            return true;
        } else {
            return false;
        }
    }

    /* [a-zA-Z0-9\\s]+ artinya:
       [a-zA-Z]: Cocokkan huruf besar atau kecil dari A hingga Z.
       [0-9]: Cocokkan angka dari 0 hingga 9.
       \\s: Cocokkan spasi.
       +: Memastikan bahwa satu karakter atau lebih cocok dengan pola yang diberikan.
     */
    private boolean isNameValid(String name) {
        return name.matches("[a-zA-Z0-9\\s]+");
    }
}