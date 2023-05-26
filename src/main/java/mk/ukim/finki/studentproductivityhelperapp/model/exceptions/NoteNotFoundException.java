package mk.ukim.finki.studentproductivityhelperapp.model.exceptions;

public class NoteNotFoundException extends RuntimeException {

    public NoteNotFoundException(Long id) {
        super(String.format("Note with id: %d does not exist!", id));
    }
}
