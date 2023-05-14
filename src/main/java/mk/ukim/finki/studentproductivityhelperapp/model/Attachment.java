package mk.ukim.finki.studentproductivityhelperapp.model;



import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.ZonedDateTime;

@Data
@Entity
public class Attachment {

    @Id
    private Long AttachmentId;
    private String Name;
    private ZonedDateTime Date;
    private String Subject;
    private String Type;
    private String ByteContent;
    @ManyToOne
    private User user;
    @ManyToOne
    private Course course;

    public Attachment() {

    }

    public Attachment(Long attachmentId, String name, ZonedDateTime date,
                      String subject, String type, String byteContent) {
        AttachmentId = attachmentId;
        Name = name;
        Date = date;
        Subject = subject;
        Type = type;
        ByteContent = byteContent;
    }
}
