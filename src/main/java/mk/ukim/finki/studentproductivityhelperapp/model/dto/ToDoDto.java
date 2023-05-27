package mk.ukim.finki.studentproductivityhelperapp.model.dto;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.studentproductivityhelperapp.model.Course;
import mk.ukim.finki.studentproductivityhelperapp.model.User;

import java.util.Date;

@Data
public class ToDoDto {

    private Long toDoId;
    private String toDoName;
    private String toDoDetails;
    private String toDoStatus;
    private Date dateCreated;
    private Date endDate;
    private Long user;
    private Long course;
    public ToDoDto() {

    }

    public ToDoDto(String toDoName, String toDoDetails, String toDoStatus, Date dateCreated, Date endDate,Long user, Long course) {
        this.toDoName = toDoName;
        this.toDoDetails = toDoDetails;
        this.toDoStatus = toDoStatus;
        this.dateCreated = dateCreated;
        this.endDate = endDate;
        this.user = user;
        this.course = course;
    }
}
