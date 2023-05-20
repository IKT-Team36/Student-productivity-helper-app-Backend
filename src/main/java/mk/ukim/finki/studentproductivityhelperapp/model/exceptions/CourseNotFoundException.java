package mk.ukim.finki.studentproductivityhelperapp.model.exceptions;


public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(Long id) {

        super(String.format("Course with course_id: %s does not exist", id));
    }

}
