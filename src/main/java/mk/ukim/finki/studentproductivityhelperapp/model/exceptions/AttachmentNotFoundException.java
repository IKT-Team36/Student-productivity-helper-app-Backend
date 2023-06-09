package mk.ukim.finki.studentproductivityhelperapp.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AttachmentNotFoundException extends RuntimeException{
    public AttachmentNotFoundException(Long attachmentId) {
        super(String.format("Attachment with attachmentId: %s already exists", attachmentId));
    }
}
