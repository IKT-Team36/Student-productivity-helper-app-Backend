package mk.ukim.finki.studentproductivityhelperapp.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import mk.ukim.finki.studentproductivityhelperapp.model.User;

import java.time.ZonedDateTime;

@Data
public class AttachmentDto {
    private String name;
    private ZonedDateTime date;

    private String subject;

    private String type;

    private String byteContent;

    private Long user;
    public AttachmentDto() {

    }

    public AttachmentDto(String name, ZonedDateTime date, String subject, String type, String byteContent, Long user) {
        this.name = name;
        this.date = date;
        this.subject = subject;
        this.type = type;
        this.byteContent = byteContent;
        this.user = user;
    }
}
