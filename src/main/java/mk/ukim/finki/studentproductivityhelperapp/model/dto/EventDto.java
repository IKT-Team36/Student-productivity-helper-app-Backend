package mk.ukim.finki.studentproductivityhelperapp.model.dto;


import lombok.Data;

import java.util.Date;

@Data
public class EventDto {

    private String eventName;
    private String eventLocation;
    private Date eventDate;
    private Long user;
    private Long course;

    public EventDto(String eventName, String eventLocation, Date eventDate, Long user, Long course) {
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.user = user;
        this.course = course;
    }
}
