package mk.ukim.finki.studentproductivityhelperapp.service;

import mk.ukim.finki.studentproductivityhelperapp.model.ToDo;

import java.util.List;

public interface ToDoService {

    public ToDo getById(Long id);

    public List<ToDo> getAll();

    public ToDo create(ToDo todo);

    public ToDo edit(Long id, ToDo todo);

    void delete(ToDo todo);
}
