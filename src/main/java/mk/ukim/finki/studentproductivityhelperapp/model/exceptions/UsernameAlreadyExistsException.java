package mk.ukim.finki.studentproductivityhelperapp.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsernameAlreadyExistsException extends RuntimeException{
    public UsernameAlreadyExistsException(String email) {
        super(String.format("User with username: %s already exists", email));
    }
}

