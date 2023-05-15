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
    private Long EventId;
    @Column(length = 50)
    private String EventName;
    @Column(length = 100)
    private String EventLocation;
    private ZonedDateTime EventDate;
    @ManyToOne
    private User user;
    @ManyToOne
    private Course course;
    public Event() {

    }

    public Event(Long eventId, String eventName, String eventLocation, ZonedDateTime eventDate) {
        EventId = eventId;
        EventName = eventName;
        EventLocation = eventLocation;
        EventDate = eventDate;
    }
}
