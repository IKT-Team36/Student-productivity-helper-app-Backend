package mk.ukim.finki.studentproductivityhelperapp.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Entity
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ToDoId;
    @Column(length = 50)
    private String ToDoName;
    @Column(length = 100)
    private String ToDoDetails;
    @Column(length = 50)
    private String ToDoStatus;
    private ZonedDateTime DateCreated;
    private ZonedDateTime EndDate;
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
