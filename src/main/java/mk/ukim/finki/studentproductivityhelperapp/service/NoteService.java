package mk.ukim.finki.studentproductivityhelperapp.service;


import mk.ukim.finki.studentproductivityhelperapp.model.Note;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.NoteDto;

import java.util.List;
import java.util.Optional;

public interface NoteService {

    List<Note> findAll();
    Optional<Note> findById(Long id);
    Optional<Note> save(NoteDto noteDto);
    Optional<Note> edit(Long id, NoteDto noteDto);
    void delete(Long id);
}
