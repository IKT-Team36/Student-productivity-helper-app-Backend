package mk.ukim.finki.studentproductivityhelperapp.service.impl;


import mk.ukim.finki.studentproductivityhelperapp.model.User;
import mk.ukim.finki.studentproductivityhelperapp.repository.UserRepository;
import mk.ukim.finki.studentproductivityhelperapp.service.UserService;
import mk.ukim.finki.studentproductivityhelperapp.service.token.ConfirmationToken;
import mk.ukim.finki.studentproductivityhelperapp.service.token.ConfirmationTokenService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, ConfirmationTokenService confirmationTokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.confirmationTokenService = confirmationTokenService;
    }



//    @Override
//    public User register(String username, String password, String repeatPassword, String FirstName, String LastName, String Email) {
//        if (username==null || username.isEmpty()  || password==null || password.isEmpty() || Email.isEmpty())
//            throw new InvalidUsernameOrPasswordException();
//        if (!password.equals(repeatPassword))
//            throw new PasswordsDoNotMatchException();
//        if(this.userRepository.findByUsername(username).isPresent())
//            throw new UsernameAlreadyExistsException(username);
//        if(this.userRepository.findByEmail(Email).isPresent())
//            throw new EmailAlreadyExistsException(Email);
//        User user = new User(username,passwordEncoder.encode(password),FirstName,LastName,Email);
//        return userRepository.save(user);
//    }

//    @Override
//    public User create(User user) {
//        // Check if the username is already taken
//        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
//            throw new UsernameAlreadyExistsException("Username already exists");
//        }
//
//        // Encrypt the user's password
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//
//        // Save the user to the database
//        return userRepository.save(user);
//    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException(email));
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public String signUpUser(User user) {
        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();
        if(userExists)
        {
            throw new IllegalStateException("email already taken");
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user

        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }

    @Override
    public int enableUser(String email) {
        return userRepository.enableUser(email);
    }
}
