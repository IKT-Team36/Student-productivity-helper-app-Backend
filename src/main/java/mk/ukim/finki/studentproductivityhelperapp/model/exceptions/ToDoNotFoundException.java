package mk.ukim.finki.studentproductivityhelperapp.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ToDoNotFoundException extends RuntimeException{
    public ToDoNotFoundException(Long toDoId) {
        super(String.format("ToDO with toDo_id: %s already exists", toDoId));
    }
}
