package mk.ukim.finki.studentproductivityhelperapp.model.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException{
    public UsernameAlreadyExistsException(String email) {
        super(String.format("User with username: %s already exists", email));
    }
}

