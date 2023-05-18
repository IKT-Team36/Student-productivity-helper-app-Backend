package mk.ukim.finki.studentproductivityhelperapp.model.exceptions;

import mk.ukim.finki.studentproductivityhelperapp.model.User;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(User user_id) {
        super(String.format("User with user_id: %s already exists", user_id));
    }
}
