package mk.ukim.finki.studentproductivityhelperapp.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.studentproductivityhelperapp.model.Course;
import mk.ukim.finki.studentproductivityhelperapp.model.Event;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.EventDto;
import mk.ukim.finki.studentproductivityhelperapp.service.CourseService;
import mk.ukim.finki.studentproductivityhelperapp.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:7762")
@RequestMapping(path = "/api/v1/registration")
@AllArgsConstructor
public class EventController {

    private EventService eventService;

    @PostMapping("/event-add")
    public ResponseEntity<Event> save(@RequestBody EventDto eventDto) {

        return this.eventService.save(eventDto)
                .map(course -> ResponseEntity.ok().body(course))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @GetMapping(path = "/events-all")
    public List<Event> listAll() {
        return this.eventService.findAll();
    }

}
