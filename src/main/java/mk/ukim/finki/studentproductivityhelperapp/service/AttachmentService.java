package mk.ukim.finki.studentproductivityhelperapp.service;

import mk.ukim.finki.studentproductivityhelperapp.model.Attachment;
import mk.ukim.finki.studentproductivityhelperapp.model.User;

import javax.swing.text.html.Option;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public interface AttachmentService {

    Optional<Attachment> create(String name, ZonedDateTime date, String subject, String type, String byteContent, User user_id);
    Optional<Attachment> update (Long attachmentId,String name, ZonedDateTime date, String subject, String type, String byteContent, User user_id);
    void delete (Long attachmentId);
    List<Attachment> listAttachments();
    List<Attachment> searchAttachments(String subject);

}
