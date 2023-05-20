package mk.ukim.finki.studentproductivityhelperapp.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.studentproductivityhelperapp.model.Note;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.NoteDto;
import mk.ukim.finki.studentproductivityhelperapp.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:7762")
@RequestMapping(path = "/api/v1/note",
        method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@AllArgsConstructor
public class NoteController {

    private NoteService noteService;

    @PostMapping("/add")
    public ResponseEntity<Note> save(@RequestBody NoteDto noteDto) {

        return this.noteService.save(noteDto)
                .map(note -> ResponseEntity.ok().body(note))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Note> edit(@PathVariable Long id, @RequestBody NoteDto noteDto) {
        return this.noteService.edit(id, noteDto)
                .map(note -> ResponseEntity.ok().body(note))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        this.noteService.delete(id);
    }

    @GetMapping("/all")
    public List<Note> listAll() {
        return this.noteService.findAll();
    }

}
