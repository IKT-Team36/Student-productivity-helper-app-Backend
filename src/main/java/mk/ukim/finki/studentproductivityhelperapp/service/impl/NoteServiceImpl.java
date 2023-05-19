package mk.ukim.finki.studentproductivityhelperapp.service.impl;


import mk.ukim.finki.studentproductivityhelperapp.model.Note;
import mk.ukim.finki.studentproductivityhelperapp.repositoryNote.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements mk.ukim.finki.studentproductivityhelperapp.service.NoteService {

    @Autowired
    private NoteRepository noteRepository;


    @Override
    public Note getById(Long id) {
        return this.noteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID: " + id));
    }

    @Override
    public List<Note> getAll() {
        return this.noteRepository.findAll();
    }

    @Override
    public Note create(Note note) {
        return this.noteRepository.save(note);
    }

    @Override
    public Note edit(Long id, Note note) {
        return null;
    }

    @Override
    public void delete(Note note) {
        this.noteRepository.delete(note);
    }
}
