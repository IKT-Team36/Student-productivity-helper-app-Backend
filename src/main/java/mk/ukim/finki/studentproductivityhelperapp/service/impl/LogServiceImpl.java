package mk.ukim.finki.studentproductivityhelperapp.service.impl;

import mk.ukim.finki.studentproductivityhelperapp.model.Course;
import mk.ukim.finki.studentproductivityhelperapp.model.Log;
import mk.ukim.finki.studentproductivityhelperapp.model.User;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.LogDto;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.CourseNotFoundException;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.LogNotFoundException;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.UserIdDoesNotExistException;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.UserNotFoundException;
import mk.ukim.finki.studentproductivityhelperapp.repository.CourseRepository;
import mk.ukim.finki.studentproductivityhelperapp.repository.LogRepository;
import mk.ukim.finki.studentproductivityhelperapp.repository.UserRepository;
import mk.ukim.finki.studentproductivityhelperapp.service.LogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public LogServiceImpl(LogRepository logRepository, UserRepository userRepository, CourseRepository courseRepository) {
        this.logRepository = logRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Log> findAll() {
        return this.logRepository.findAll();
    }

    @Override
    public Optional<Log> findById(Long id) {

        return this.logRepository.findById(id);
    }

    @Override
    public Optional<Log> save(LogDto logDto) {
        User user = this.userRepository.findById(logDto.getUser())
                .orElseThrow(() -> new UserIdDoesNotExistException(logDto.getUser()));
        Course course = this.courseRepository.findById(logDto.getCourse())
                .orElseThrow(() -> new CourseNotFoundException(logDto.getCourse()));
        Log log = new Log(logDto.getLogContent(), user, course);
        this.logRepository.save(log);
        return Optional.of(log);
    }

    @Override
    public Optional<Log> edit(Long id, LogDto logDto) {
        Log log = this.logRepository.findById(id)
                .orElseThrow(() -> new LogNotFoundException(id));
        log.setLogContent(logDto.getLogContent());
        this.logRepository.save(log);
        return Optional.of(log);
    }

    @Override
    public void delete(Long logId) {
        Log log = this.logRepository.findById(logId)
                .orElseThrow(() -> new LogNotFoundException(logId));
        this.logRepository.delete(log);
    }
}
