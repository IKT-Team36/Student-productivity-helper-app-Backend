package mk.ukim.finki.studentproductivityhelperapp.model.exceptions;

public class UserIdDoesNotExistException extends RuntimeException {

    public UserIdDoesNotExistException(Long id) {
        super(String.format("User with id: %s does not exist", id));
    }
}
