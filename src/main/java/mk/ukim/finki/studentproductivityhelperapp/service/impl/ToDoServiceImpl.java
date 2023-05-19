package mk.ukim.finki.studentproductivityhelperapp.service.impl;


import mk.ukim.finki.studentproductivityhelperapp.model.ToDo;
import mk.ukim.finki.studentproductivityhelperapp.repositoryNote.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServiceImpl implements mk.ukim.finki.studentproductivityhelperapp.service.ToDoService {

    @Autowired
    private ToDoRepository todoRepository;


    @Override
    public ToDo getById(Long id) {
        return this.todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID: " + id));
    }

    @Override
    public List<ToDo> getAll() {
        return this.todoRepository.findAll();
    }

    @Override
    public ToDo create(ToDo ToDo) {
        return this.todoRepository.save(ToDo);
    }

    @Override
    public ToDo edit(Long id, ToDo ToDo) {
        return null;
    }

    @Override
    public void delete(ToDo ToDo) {
        this.todoRepository.delete(ToDo);
    }
}
