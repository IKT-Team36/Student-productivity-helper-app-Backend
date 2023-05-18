package mk.ukim.finki.studentproductivityhelperapp.service.impl;

import mk.ukim.finki.studentproductivityhelperapp.model.Course;
import mk.ukim.finki.studentproductivityhelperapp.model.User;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.CourseDto;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.UserEmailDoesNotExistException;
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
                .orElseThrow(() -> new UserEmailDoesNotExistException(courseDto.getUser()));
        System.out.println(user.getEmail());
        Course course = new Course(courseDto.getName(), courseDto.getSemester(),
                courseDto.getDescription(), courseDto.getCourseStatus(), user);
        System.out.println(course);
        this.courseRepository.save(course);
        return Optional.of(course);
    }

    @Override
    public Optional<Course> save(String Name, String Semester, String Description, String CourseStatus, String User) {
//        User user = this.userRepository.findByEmail(User)
//                .orElseThrow(() -> new UserEmailDoesNotExistException(User));
        User user = new User();
        Course course = new Course(Name, Semester, Description, CourseStatus, user);
        this.courseRepository.save(course);
        return Optional.of(course);
    }
}
