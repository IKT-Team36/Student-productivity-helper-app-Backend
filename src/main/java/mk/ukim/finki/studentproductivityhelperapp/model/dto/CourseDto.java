package mk.ukim.finki.studentproductivityhelperapp.model.dto;

import lombok.Data;

@Data
public class CourseDto {

    private String name;
    private String semester;
    private String description;
    private String courseStatus;
    private Long user;

    public CourseDto() {
    }

    public CourseDto(String name, String semester, String description, String courseStatus, Long user) {
        this.name = name;
        this.semester = semester;
        this.description = description;
        this.courseStatus = courseStatus;
        this.user = user;
    }

}
