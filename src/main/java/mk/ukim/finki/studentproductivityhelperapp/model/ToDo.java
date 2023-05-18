package mk.ukim.finki.studentproductivityhelperapp.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Entity
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long toDoId;
    @Column(length = 50)
    private String toDoName;
    @Column(length = 100)
    private String toDoDetails;
    @Column(length = 50)
    private String toDoStatus;
    private ZonedDateTime dateCreated;
    private ZonedDateTime endDate;
    public ToDo() {

    }

    public ToDo(String toDoName, String toDoDetails, String toDoStatus, ZonedDateTime dateCreated, ZonedDateTime endDate) {
        this.toDoName = toDoName;
        this.toDoDetails = toDoDetails;
        this.toDoStatus = toDoStatus;
        this.dateCreated = dateCreated;
        this.endDate = endDate;
    }
}
