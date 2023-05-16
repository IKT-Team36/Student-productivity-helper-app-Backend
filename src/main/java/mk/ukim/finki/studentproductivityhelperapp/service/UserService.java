package mk.ukim.finki.studentproductivityhelperapp.service;



import mk.ukim.finki.studentproductivityhelperapp.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> findAll();
    public String signUpUser(User user);
    public int enableUser(String email) ;
}
