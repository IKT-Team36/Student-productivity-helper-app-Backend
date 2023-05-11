package mk.ukim.finki.studentproductivityhelperapp.service;



import mk.ukim.finki.studentproductivityhelperapp.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User register(String username, String password, String repeatPassword, String FirstName, String LastName,
                  String Email);
}
