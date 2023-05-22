package mk.ukim.finki.studentproductivityhelperapp.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.studentproductivityhelperapp.model.Attachment;
import mk.ukim.finki.studentproductivityhelperapp.model.ToDo;
import mk.ukim.finki.studentproductivityhelperapp.model.Topic;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.AttachmentDto;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.ToDoDto;
import mk.ukim.finki.studentproductivityhelperapp.service.ToDoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:7762")
@RequestMapping(path = "/api/v1/toDo")
@AllArgsConstructor
public class ToDoController {
    private final ToDoService toDoService;

    @GetMapping("/allToDos")
    public List<ToDo> findAll() {
        return this.toDoService.listToDos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> findById(@PathVariable Long id) {
        return this.toDoService.findById(id)
                .map(toDo -> ResponseEntity.ok().body(toDo))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<ToDo> save(@RequestBody ToDoDto toDoDto) {
        return this.toDoService.save(toDoDto)
                .map(toDo -> ResponseEntity.ok().body(toDo))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ToDo> save(@PathVariable Long id, @RequestBody ToDoDto toDoDto) {
        return this.toDoService.edit(id, toDoDto)
                .map(toDo -> ResponseEntity.ok().body(toDo))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.toDoService.deleteById(id);
        if(this.toDoService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
