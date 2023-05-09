package mk.ukim.finki.studentproductivityhelperapp.model.exceptions;

public class EmailAlreadyExistsException  extends RuntimeException {
    public EmailAlreadyExistsException(String Email) {
        super(String.format("User with Email: %s already exists", Email));
    }
}
