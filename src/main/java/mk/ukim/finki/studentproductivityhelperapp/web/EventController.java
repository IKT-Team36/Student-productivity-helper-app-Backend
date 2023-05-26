package mk.ukim.finki.studentproductivityhelperapp.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.studentproductivityhelperapp.model.Course;
import mk.ukim.finki.studentproductivityhelperapp.model.Event;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.CourseDto;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.EventDto;
import mk.ukim.finki.studentproductivityhelperapp.service.CourseService;
import mk.ukim.finki.studentproductivityhelperapp.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:7762")
@RequestMapping(path = "/api/v1/event",
        method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@AllArgsConstructor
public class EventController {

    private EventService eventService;

    @PostMapping("/add")
    public ResponseEntity<Event> save(@RequestBody EventDto eventDto) {

        return this.eventService.save(eventDto)
                .map(course -> ResponseEntity.ok().body(course))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Event> edit(@PathVariable Long id, @RequestBody EventDto eventDto) {
        return this.eventService.edit(id, eventDto)
                .map(event -> ResponseEntity.ok().body(event))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        this.eventService.delete(id);
    }

    @GetMapping(path = "/all")
    public List<Event> listAll() {
        return this.eventService.findAll();
    }

}
