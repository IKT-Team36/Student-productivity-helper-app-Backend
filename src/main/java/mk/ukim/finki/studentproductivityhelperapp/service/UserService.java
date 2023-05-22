package mk.ukim.finki.studentproductivityhelperapp.service;



import mk.ukim.finki.studentproductivityhelperapp.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    List<User> findAll();

     String signUpUser(User user);

     int enableUser(String email);

    Optional<User> findById(Long id);
}
