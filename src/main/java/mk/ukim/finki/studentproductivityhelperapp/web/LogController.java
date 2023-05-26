package mk.ukim.finki.studentproductivityhelperapp.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.studentproductivityhelperapp.model.Event;
import mk.ukim.finki.studentproductivityhelperapp.model.Log;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.EventDto;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.LogDto;
import mk.ukim.finki.studentproductivityhelperapp.service.EventService;
import mk.ukim.finki.studentproductivityhelperapp.service.LogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:7762")
@RequestMapping(path = "/api/v1/log",
        method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@AllArgsConstructor
public class LogController {

    private LogService logService;

    @PostMapping("/add")
    public ResponseEntity<Log> save(@RequestBody LogDto logDto) {

        return this.logService.save(logDto)
                .map(log -> ResponseEntity.ok().body(log))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Log> edit(@PathVariable Long id, @RequestBody LogDto logDto) {
        return this.logService.edit(id, logDto)
                .map(log -> ResponseEntity.ok().body(log))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        this.logService.delete(id);
    }

    @GetMapping(path = "/all")
    public List<Log> listAll() {

        return this.logService.findAll();
    }

}
