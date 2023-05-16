package mk.ukim.finki.studentproductivityhelperapp.service.impl;

import mk.ukim.finki.studentproductivityhelperapp.model.Attachment;
import mk.ukim.finki.studentproductivityhelperapp.model.User;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.AttachmentNotFoundException;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.UserNotFoundException;
import mk.ukim.finki.studentproductivityhelperapp.repository.AttachmentRepository;
import mk.ukim.finki.studentproductivityhelperapp.repository.UserRepository;
import mk.ukim.finki.studentproductivityhelperapp.service.AttachmentService;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository attachmentRepository;
    private final UserRepository userRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository, UserRepository userRepository) {
        this.attachmentRepository = attachmentRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Optional<Attachment> create(String name, ZonedDateTime date, String subject, String type, String byteContent, User user_id) {
        User user = this.userRepository.findById(user_id).orElseThrow(()->new UserNotFoundException(user_id));

        Attachment attachment = new Attachment(name,date,subject,type,byteContent,user);
        this.attachmentRepository.save(attachment);
        return Optional.of(attachment);

    }

    @Override
    public Optional<Attachment> update(Long attachmentId,String name, ZonedDateTime date, String subject, String type, String byteContent,User user_id) {
        Attachment attachment = this.attachmentRepository.findById(attachmentId).orElseThrow(()->new AttachmentNotFoundException(attachmentId));
        attachment.setName(name);
        attachment.setDate(date);
        attachment.setSubject(subject);
        attachment.setType(type);
        attachment.setByteContent(byteContent);

        User user = this.userRepository.findById(user_id).orElseThrow(()->new UserNotFoundException(user_id));
        attachment.setUser(user);

        this.attachmentRepository.save(attachment);
        return Optional.of(attachment);

    }

    @Override
    public void delete(Long attachmentId) {
            this.attachmentRepository.deleteById(attachmentId);
    }

    @Override
    public List<Attachment> listAttachments() {
        return this.attachmentRepository.findAll();
    }

    @Override
    public List<Attachment> searchAttachments(String subject) {
        return this.attachmentRepository.findBySubject(subject);
    }
}
