package mk.ukim.finki.studentproductivityhelperapp.service.impl;

import mk.ukim.finki.studentproductivityhelperapp.model.Attachment;
import mk.ukim.finki.studentproductivityhelperapp.model.User;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.AttachmentDto;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.AttachmentNotFoundException;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.UserNotFoundException;
import mk.ukim.finki.studentproductivityhelperapp.repository.AttachmentRepository;
import mk.ukim.finki.studentproductivityhelperapp.repository.UserRepository;
import mk.ukim.finki.studentproductivityhelperapp.service.AttachmentService;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public Optional<Attachment> create(String name, Date date, String subject, String type, String byteContent, Long user) {

        User userNEW = this.userRepository.findById(user).orElseThrow(()->new UserNotFoundException(user));
        this.attachmentRepository.deleteByName(name);
        return Optional.of(this.attachmentRepository.save(new Attachment(name, date, subject, type, byteContent, userNEW)));

    }

    @Override
    public Optional<Attachment> edit(Long attachmentId,String name, Date date, String subject, String type, String byteContent,Long user) {
        Attachment attachment = this.attachmentRepository.findById(attachmentId).orElseThrow(()->new AttachmentNotFoundException(attachmentId));
        attachment.setName(name);
        attachment.setDate(date);
        attachment.setSubject(subject);
        attachment.setType(type);
        attachment.setByteContent(byteContent);

        User userNEW = this.userRepository.findById(user).orElseThrow(()->new UserNotFoundException(user));
        attachment.setUser(userNEW);


        return Optional.of(this.attachmentRepository.save(attachment));

    }

    @Override
    public Optional<Attachment> save(AttachmentDto attachmentDto) {
        User user = this.userRepository.findById(attachmentDto.getUser()).orElseThrow(()->new UserNotFoundException(attachmentDto.getUser()));
        this.attachmentRepository.deleteByName(attachmentDto.getName());
        return Optional.of(this.attachmentRepository.
                save(new Attachment(attachmentDto.getName(), attachmentDto.getDate(),
                        attachmentDto.getSubject(), attachmentDto.getType(),attachmentDto.getByteContent(), user)));
    }

    @Override
    public Optional<Attachment> edit(Long attachmentId, AttachmentDto attachmentDto) {
        Attachment attachment = this.attachmentRepository.findById(attachmentId).orElseThrow(()->new AttachmentNotFoundException(attachmentId));

        attachment.setName(attachmentDto.getName());
        attachment.setDate(attachmentDto.getDate());
        attachment.setSubject(attachmentDto.getSubject());
        attachment.setType(attachmentDto.getType());
        attachment.setByteContent(attachmentDto.getByteContent());

        User user = this.userRepository.findById(attachmentDto.getUser()).orElseThrow(()->new UserNotFoundException(attachmentDto.getUser()));
        attachment.setUser(user);

        return Optional.of(this.attachmentRepository.save(attachment));

    }

    @Override
    public void deleteById(Long attachmentId) {
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

    @Override
    public Optional<Attachment> findById(Long attachmentId) {
        return this.attachmentRepository.findById(attachmentId);
    }
//
//    @Override
//    public Attachment saveAtt(Attachment attachment) {
//        return this.attachmentRepository.save(attachment);
//    }

}
