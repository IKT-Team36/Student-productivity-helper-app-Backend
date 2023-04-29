package mk.ukim.finki.studentproductivityhelperapp.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.ZonedDateTime;

@Data
@Entity
public class ToDo {

    @Id
    private Long ToDoId;
    private String ToDoName;
    private String ToDoDetails;
    private String ToDoStatus;
    private ZonedDateTime DateCreated;
    private ZonedDateTime EndDate;
    @ManyToOne
    private User user;
    @ManyToOne
    private Course course;
    public ToDo() {

    }

    public ToDo(Long toDoId, String toDoName, String toDoDetails, String toDoStatus,
                ZonedDateTime dateCreated, ZonedDateTime endDate) {
        ToDoId = toDoId;
        ToDoName = toDoName;
        ToDoDetails = toDoDetails;
        ToDoStatus = toDoStatus;
        DateCreated = dateCreated;
        EndDate = endDate;
    }
}
