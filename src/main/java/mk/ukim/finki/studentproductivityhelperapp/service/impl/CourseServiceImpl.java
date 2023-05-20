package mk.ukim.finki.studentproductivityhelperapp.service.impl;

import mk.ukim.finki.studentproductivityhelperapp.model.Course;
import mk.ukim.finki.studentproductivityhelperapp.model.User;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.CourseDto;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.CourseNotFoundException;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.UserIdDoesNotExistException;
import mk.ukim.finki.studentproductivityhelperapp.repository.CourseRepository;
import mk.ukim.finki.studentproductivityhelperapp.repository.UserRepository;
import mk.ukim.finki.studentproductivityhelperapp.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseServiceImpl(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Course> findAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Course> save(CourseDto courseDto) {
        User user = this.userRepository.findById(courseDto.getUser())
                .orElseThrow(() -> new UserIdDoesNotExistException(courseDto.getUser()));
        Course course = new Course(courseDto.getName(), courseDto.getSemester(),
                courseDto.getDescription(), courseDto.getCourseStatus(), user);
        this.courseRepository.save(course);
        return Optional.of(course);
    }

    @Override
    public Optional<Course> edit(Long id, CourseDto courseDto) {
        Course course = this.courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));

        course.setDescription(courseDto.getDescription());
        course.setCourseStatus(courseDto.getCourseStatus());
        course.setName(courseDto.getName());
        course.setSemester(courseDto.getSemester());

        this.courseRepository.save(course);
        return Optional.of(course);
    }

    @Override
    public Optional<Course> delete(Long id) {
        Course course = this.courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
        this.courseRepository.deleteCourse(id);
//        this.courseRepository.save(course);
//        return Optional.of(course);
        return Optional.of(course);
    }

}
