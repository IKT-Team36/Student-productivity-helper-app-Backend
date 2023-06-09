package mk.ukim.finki.studentproductivityhelperapp.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import mk.ukim.finki.studentproductivityhelperapp.model.User;

import java.util.Date;


@Data
public class AttachmentDto {
    private String name;
    private Date date;

    private String subject;

    private String type;

    private String byteContent;

    private Long user;
    public AttachmentDto() {

    }

    public AttachmentDto(String name, Date date, String subject, String type, String byteContent, Long user) {
        this.name = name;
        this.date = date;
        this.subject = subject;
        this.type = type;
        this.byteContent = byteContent;
        this.user = user;
    }
}
