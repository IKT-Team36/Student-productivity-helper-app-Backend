package mk.ukim.finki.studentproductivityhelperapp.service;

import mk.ukim.finki.studentproductivityhelperapp.model.ToDo;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.ToDoDto;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.TopicDto;

import java.util.List;
import java.util.Optional;

public interface ToDoService {

    Optional<ToDo> save(ToDoDto toDoDto);

    Optional<ToDo> edit(Long toDoId, ToDoDto toDoDto);


    void deleteById(Long toDoId);
    List<ToDo> listToDos();

    Optional<ToDo> findById(Long toDoId);
}
