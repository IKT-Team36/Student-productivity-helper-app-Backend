package mk.ukim.finki.studentproductivityhelperapp.service;

import mk.ukim.finki.studentproductivityhelperapp.model.Attachment;
import mk.ukim.finki.studentproductivityhelperapp.model.User;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.AttachmentDto;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public interface AttachmentService {

    Optional<Attachment> create(String name, ZonedDateTime date, String subject, String type, String byteContent, Long user);
    Optional<Attachment> edit (Long attachmentId,String name, ZonedDateTime date, String subject, String type, String byteContent, Long user);

    Optional<Attachment> save(AttachmentDto attachmentDto);

    Optional<Attachment> edit(Long attachmentId, AttachmentDto attachmentDto);


    void deleteById(Long attachmentId);
    List<Attachment> listAttachments();
    List<Attachment> searchAttachments(String subject);

    Optional<Attachment> findById(Long attachmentId);
}
