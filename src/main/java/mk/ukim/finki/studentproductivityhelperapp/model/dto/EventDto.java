package mk.ukim.finki.studentproductivityhelperapp.model.dto;


import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class EventDto {

    private String eventName;
    private String eventLocation;
    private ZonedDateTime eventDate;
    private Long user;
    private Long course;

    public EventDto(String eventName, String eventLocation, ZonedDateTime eventDate, Long user, Long course) {
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.user = user;
        this.course = course;
    }
}
