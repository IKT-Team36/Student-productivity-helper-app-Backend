package mk.ukim.finki.studentproductivityhelperapp.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.studentproductivityhelperapp.model.AppUserRole;
import mk.ukim.finki.studentproductivityhelperapp.model.User;
import mk.ukim.finki.studentproductivityhelperapp.service.RegistrationService;
import mk.ukim.finki.studentproductivityhelperapp.service.UserService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;

    @Override
    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail)
        {
            throw new IllegalArgumentException("email not valid");
        }
        return userService.signUpUser(
                new User(
                        request.getEmail(),request.getFirstName(),request.getLastName(),request.getPassword(), AppUserRole.USER
                )
        );
    }
}
