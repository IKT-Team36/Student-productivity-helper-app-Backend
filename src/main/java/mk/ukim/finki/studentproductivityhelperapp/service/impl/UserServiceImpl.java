package mk.ukim.finki.studentproductivityhelperapp.service.impl;

import mk.ukim.finki.studentproductivityhelperapp.model.User;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.EmailAlreadyExistsException;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.InvalidUsernameOrPasswordException;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.UsernameAlreadyExistsException;
import mk.ukim.finki.studentproductivityhelperapp.repository.UserRepository;
import mk.ukim.finki.studentproductivityhelperapp.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User register(String username, String password, String repeatPassword, String FirstName, String LastName, String Email) {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty() || Email.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        if(this.userRepository.findByEmail(Email).isPresent())
            throw new EmailAlreadyExistsException(Email);
        User user = new User(username,passwordEncoder.encode(password),FirstName,LastName,Email);
        return userRepository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));
    }
}
