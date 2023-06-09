package mk.ukim.finki.studentproductivityhelperapp.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException(Long courseId) {
        super(String.format("Course with course_id: %s already exists", courseId));
    }
}
