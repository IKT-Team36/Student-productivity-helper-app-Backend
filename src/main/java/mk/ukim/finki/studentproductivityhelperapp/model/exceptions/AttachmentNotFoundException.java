package mk.ukim.finki.studentproductivityhelperapp.model.exceptions;

public class AttachmentNotFoundException extends RuntimeException{
    public AttachmentNotFoundException(Long attachmentId) {
        super(String.format("Attachment with attachmentId: %s already exists", attachmentId));
    }
}
