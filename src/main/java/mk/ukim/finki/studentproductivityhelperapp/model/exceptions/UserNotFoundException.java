package mk.ukim.finki.studentproductivityhelperapp.model.exceptions;

import mk.ukim.finki.studentproductivityhelperapp.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id) {
        super(String.format("User with user_id: %s already exists", id));
    }

}
