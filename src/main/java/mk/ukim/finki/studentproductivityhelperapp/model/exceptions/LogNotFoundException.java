package mk.ukim.finki.studentproductivityhelperapp.model.exceptions;

public class LogNotFoundException extends RuntimeException {

    public LogNotFoundException(Long id) {
        super(String.format("Log with id: %d does not exist", id));
    }
}
