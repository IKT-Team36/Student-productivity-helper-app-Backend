package mk.ukim.finki.studentproductivityhelperapp.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.ZonedDateTime;

@Data
@Entity
public class Event {

    @Id
    private Long EventId;
    private String EventName;
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
