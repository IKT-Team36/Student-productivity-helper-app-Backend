package mk.ukim.finki.studentproductivityhelperapp.service.impl;

import mk.ukim.finki.studentproductivityhelperapp.service.RegistrationService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Override
    public String register(RegistrationRequest request) {
        return "works";
    }
}
