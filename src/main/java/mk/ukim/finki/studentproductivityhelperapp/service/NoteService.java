package mk.ukim.finki.studentproductivityhelperapp.service;

import mk.ukim.finki.studentproductivityhelperapp.model.Note;

import java.util.List;

public interface NoteService {

    public Note getById(Long id);

    public List<Note> getAll();

    public Note create(Note note);

    public Note edit(Long id, Note note);

    void delete(Note note);
}
