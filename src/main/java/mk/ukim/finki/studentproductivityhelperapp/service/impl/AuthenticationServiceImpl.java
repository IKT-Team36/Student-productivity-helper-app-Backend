package mk.ukim.finki.studentproductivityhelperapp.service.impl;

import mk.ukim.finki.studentproductivityhelperapp.service.AuthenticationService;
import mk.ukim.finki.studentproductivityhelperapp.service.UserService;
import mk.ukim.finki.studentproductivityhelperapp.service.token.JwtTokenUtil;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserService userService;

    public AuthenticationServiceImpl(JwtTokenUtil jwtTokenUtil, UserService userService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    @Override
    public boolean validateToken(String token) {
        String username = this.jwtTokenUtil.extractUsername(token);
        UserDetails userDetails = this.userService.loadUserByUsername(username);
        return jwtTokenUtil.validateToken(token, userDetails);
    }

}
