package mk.ukim.finki.studentproductivityhelperapp.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.studentproductivityhelperapp.service.RegistrationService;
import mk.ukim.finki.studentproductivityhelperapp.service.impl.RegistrationRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

}
