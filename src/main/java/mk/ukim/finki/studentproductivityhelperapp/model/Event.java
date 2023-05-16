package mk.ukim.finki.studentproductivityhelperapp.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "`event`", schema = "dbo")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    @Column(length = 50)
    private String eventName;
    @Column(length = 100)
    private String eventLocation;
    private ZonedDateTime eventDate;
    @ManyToOne
    private User user;
    @ManyToOne
    private Course course;
    public Event() {

    }

    public Event(String eventName, String eventLocation, ZonedDateTime eventDate) {
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
    }

    public Event(String eventName, String eventLocation, ZonedDateTime eventDate, User user, Course course) {
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.user = user;
        this.course = course;
    }
}
