package mk.ukim.finki.studentproductivityhelperapp.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.studentproductivityhelperapp.model.ToDo;
import mk.ukim.finki.studentproductivityhelperapp.model.Topic;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.ToDoDto;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.TopicDto;
import mk.ukim.finki.studentproductivityhelperapp.service.TopicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:7762")
@RequestMapping(path = "/api/v1/topic")
@AllArgsConstructor
public class TopicController {
    private final TopicService topicService;

    @GetMapping("/allTopics")
    public List<Topic> findAll() {
        return this.topicService.listTopics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> findById(@PathVariable Long id) {
        return this.topicService.findById(id)
                .map(topic -> ResponseEntity.ok().body(topic))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Topic> save(@RequestBody TopicDto topicDto) {
        return this.topicService.save(topicDto)
                .map(topic -> ResponseEntity.ok().body(topic))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Topic> save(@PathVariable Long id, @RequestBody TopicDto topicDto) {
        return this.topicService.edit(id, topicDto)
                .map(topic -> ResponseEntity.ok().body(topic))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.topicService.deleteById(id);
        if(this.topicService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
