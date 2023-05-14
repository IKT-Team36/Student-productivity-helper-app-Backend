package mk.ukim.finki.studentproductivityhelperapp.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.studentproductivityhelperapp.model.User;
import mk.ukim.finki.studentproductivityhelperapp.service.RegistrationService;
import mk.ukim.finki.studentproductivityhelperapp.service.UserService;
import mk.ukim.finki.studentproductivityhelperapp.service.impl.RegistrationRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:7762")
@RequestMapping(path = "/api/registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;
    private UserService userService;

    @PostMapping()
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }


    @GetMapping
    public List<User> listAll(){
        return this.userService.findAll();
    }

}
