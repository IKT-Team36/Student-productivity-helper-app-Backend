package mk.ukim.finki.studentproductivityhelperapp.service;

import mk.ukim.finki.studentproductivityhelperapp.model.Course;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.CourseDto;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> findAll();
    Optional<Course> findById(Long id);
    Optional<Course> save(CourseDto courseDto);
    Optional<Course> save(String Name, String Semester, String Description, String CourseStatus, String User);
}
