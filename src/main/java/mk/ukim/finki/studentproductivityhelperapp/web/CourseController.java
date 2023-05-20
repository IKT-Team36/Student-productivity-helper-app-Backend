package mk.ukim.finki.studentproductivityhelperapp.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.studentproductivityhelperapp.model.Course;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.CourseDto;
import mk.ukim.finki.studentproductivityhelperapp.service.CourseService;
import mk.ukim.finki.studentproductivityhelperapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:7762")
@RequestMapping(path = "/api/v1/course",
        method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@AllArgsConstructor
public class CourseController {

    private CourseService courseService;
    private UserService userService;
    @PostMapping("/add")
    public ResponseEntity<Course> save(@RequestBody CourseDto courseDto) {

        return this.courseService.save(courseDto)
                .map(course -> ResponseEntity.ok().body(course))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Course> edit(@PathVariable Long id, @RequestBody CourseDto courseDto) {
        return this.courseService.edit(id, courseDto)
                .map(course -> ResponseEntity.ok().body(course))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        this.courseService.delete(id);
    }

    @GetMapping("/all")
    public List<Course> listAll(Authentication authentication) { //

//        User user = (User) authentication.getPrincipal();
//        System.out.println(user);
        return courseService.findAll();
    }

}
