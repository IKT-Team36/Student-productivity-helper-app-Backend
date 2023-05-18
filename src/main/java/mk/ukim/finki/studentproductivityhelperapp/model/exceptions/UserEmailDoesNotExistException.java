package mk.ukim.finki.studentproductivityhelperapp.model.exceptions;

public class UserEmailDoesNotExistException extends RuntimeException {

    public UserEmailDoesNotExistException(Long email) {
        super(String.format("User with email: %s does not exist", email));
    }
}
