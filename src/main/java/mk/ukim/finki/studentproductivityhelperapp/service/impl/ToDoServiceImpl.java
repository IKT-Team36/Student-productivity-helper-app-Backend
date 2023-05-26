package mk.ukim.finki.studentproductivityhelperapp.service.impl;

import mk.ukim.finki.studentproductivityhelperapp.model.Course;
import mk.ukim.finki.studentproductivityhelperapp.model.ToDo;
import mk.ukim.finki.studentproductivityhelperapp.model.User;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.ToDoDto;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.CourseNotFoundException;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.ToDoNotFoundException;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.UserNotFoundException;
import mk.ukim.finki.studentproductivityhelperapp.repository.CourseRepository;
import mk.ukim.finki.studentproductivityhelperapp.repository.ToDoRepository;
import mk.ukim.finki.studentproductivityhelperapp.repository.UserRepository;
import mk.ukim.finki.studentproductivityhelperapp.service.ToDoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static ch.qos.logback.core.joran.spi.ConsoleTarget.SystemOut;

@Service
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository toDoRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public ToDoServiceImpl(ToDoRepository toDoRepository, UserRepository userRepository, CourseRepository courseRepository) {
        this.toDoRepository = toDoRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Optional<ToDo> save(ToDoDto toDoDto) {
//        User currentUser = currentUserProvider.getCurrentUser();
//        String currentEmail = currentUserProvider.getCurrentUserEmail();
//        System.out.println(currentEmail);
//
//        User user = this.userRepository.findByEmail(currentEmail).orElseThrow(()-> new RuntimeException("user not found"));
       User user = this.userRepository.findById(toDoDto.getUser()).orElseThrow(()->new UserNotFoundException(toDoDto.getUser()));

        Course course = this.courseRepository.findById(toDoDto.getCourse()).orElseThrow(()->new CourseNotFoundException(toDoDto.getCourse()));

        this.toDoRepository.deleteBytoDoName(toDoDto.getToDoName());
        return Optional.of(this.toDoRepository.
                save(new ToDo(toDoDto.getToDoName(),toDoDto.getToDoDetails(),
                        toDoDto.getToDoStatus(),toDoDto.getDateCreated(),toDoDto.getEndDate(),user,course)));
    }

    @Override
    public Optional<ToDo> edit(Long toDoId, ToDoDto toDoDto) {
        ToDo toDo = this.toDoRepository.findById(toDoId).orElseThrow(()->new ToDoNotFoundException(toDoId));

        toDo.setToDoName(toDoDto.getToDoName());
        toDo.setToDoDetails(toDoDto.getToDoDetails());
        toDo.setToDoStatus(toDoDto.getToDoStatus());
        toDo.setDateCreated(toDoDto.getDateCreated());
        toDo.setEndDate(toDoDto.getEndDate());
//        String currentUser = currentUserProvider.getCurrentUser();
        //User user = this.userRepository.findById(toDoDto.getUser()).orElseThrow(()->new UserNotFoundException(toDoDto.getUser()));
        Course course = this.courseRepository.findById(toDoDto.getCourse()).orElseThrow(()->new CourseNotFoundException(toDoDto.getCourse()));

//        toDo.setUser(currentUser);
        toDo.setCourse(course);

        return Optional.of(this.toDoRepository.save(toDo));

    }

    @Override
    public void deleteById(Long toDoId) {
        this.toDoRepository.deleteById(toDoId);
    }

    @Override
    public List<ToDo> listToDos() {
        return this.toDoRepository.findAll();
    }

    @Override
    public Optional<ToDo> findById(Long toDoId) {
        return this.toDoRepository.findById(toDoId);
    }
}
