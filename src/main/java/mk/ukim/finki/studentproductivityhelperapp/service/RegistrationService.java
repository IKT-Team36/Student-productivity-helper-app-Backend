package mk.ukim.finki.studentproductivityhelperapp.service;

import mk.ukim.finki.studentproductivityhelperapp.service.impl.RegistrationRequest;

public interface RegistrationService {
     String register(RegistrationRequest request);
    String confirmToken(String token);
}
