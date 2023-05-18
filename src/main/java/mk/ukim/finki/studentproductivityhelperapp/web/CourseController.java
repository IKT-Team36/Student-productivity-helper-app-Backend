package mk.ukim.finki.studentproductivityhelperapp.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.studentproductivityhelperapp.model.Course;
import mk.ukim.finki.studentproductivityhelperapp.model.User;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.CourseDto;
import mk.ukim.finki.studentproductivityhelperapp.service.CourseService;
import mk.ukim.finki.studentproductivityhelperapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:7762")
@RequestMapping(path = "/api/v1/courses")
@AllArgsConstructor
public class CourseController {

    private CourseService courseService;
    private UserService userService;
//    @PostMapping("/add")
//    public ResponseEntity<Course> save(@RequestBody CourseDto courseDto) {
////        User user = (User) authentication.getPrincipal();
////        courseDto.setUser(user.);
//        return this.courseService.save(courseDto)
//                .map(course -> ResponseEntity.ok().body(course))
//                .orElseGet(() -> ResponseEntity.badRequest().build());
//
//    }

//    @GetMapping(path = "/all")
//    public List<Course> listAll(){
//        return this.courseService.findAll();
//    }

    @GetMapping("/all")
    public List<User> listAllCourses(){
        return this.userService.findAll();
    }
    @PostMapping("/addnew")
    public ResponseEntity<Course> save(@RequestParam String Name,
                                       @RequestParam String Semester,
                                       @RequestParam String Description,
                                       @RequestParam String CourseStatus,
                                       @RequestParam String User
                                       ) {
    //        User user = (User) authentication.getPrincipal();
    //        courseDto.setUser(user.);
        return this.courseService.save(Name, Semester, Description, CourseStatus, User)
                .map(course -> ResponseEntity.ok().body(course))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }
}
