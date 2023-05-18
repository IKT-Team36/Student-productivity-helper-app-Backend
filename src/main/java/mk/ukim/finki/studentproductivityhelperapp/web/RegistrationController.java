package mk.ukim.finki.studentproductivityhelperapp.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.studentproductivityhelperapp.model.User;
import mk.ukim.finki.studentproductivityhelperapp.service.RegistrationService;
import mk.ukim.finki.studentproductivityhelperapp.service.UserService;
import mk.ukim.finki.studentproductivityhelperapp.service.impl.RegistrationRequest;
import mk.ukim.finki.studentproductivityhelperapp.service.token.ConfirmationTokenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:7762")
@RequestMapping(path = "/api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;


    @PostMapping()
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
