package mk.ukim.finki.studentproductivityhelperapp.web;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mk.ukim.finki.studentproductivityhelperapp.login.LoginRequest;
import mk.ukim.finki.studentproductivityhelperapp.login.LoginResponse;
import mk.ukim.finki.studentproductivityhelperapp.service.AuthenticationService;
import mk.ukim.finki.studentproductivityhelperapp.service.token.JwtTokenUtil;
import mk.ukim.finki.studentproductivityhelperapp.service.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/login",
        method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserService userService;
    private final AuthenticationService authenticationService;

    public LoginController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, UserService userService, AuthenticationService authenticationService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest,
                                               HttpServletRequest request, HttpServletResponse httpServletResponse) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userService.loadUserByUsername(loginRequest.getEmail());
        String token = jwtTokenUtil.generateToken(userDetails);


//        cookie.setSecure(true); // Enable secure flag for HTTPS
//        cookie.setHttpOnly(true); // Make the cookie accessible only via HTTP(s)
         // Set the expiration time for the cookie (in seconds)
//        cookie.setPath("/"); // Set the cookie path

        // Add the cookie to the response


        LoginResponse response = new LoginResponse(token);

        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(300000);
        httpServletResponse.addCookie(cookie);

        String username = this.jwtTokenUtil.extractUsername(token);
        System.out.println(username);
        HttpSession session = request.getSession();
        session.setAttribute("token", token);
        return ResponseEntity.ok(response);
    }



    @GetMapping("/validation")
    public ResponseEntity<String> getProtectedResource(@RequestHeader("Authorization") String token) {
        // Extract the token from the Authorization header

        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7); // Remove the "Bearer " prefix
        } else {
            // Token is missing or improperly formatted
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }

        // Validate the token
        boolean isValidToken = authenticationService.validateToken(token);

        if (isValidToken) {
            // Token is valid, proceed with the requested operation
            String response = "You have access to the protected resource";
            return ResponseEntity.ok(response);
        } else {
            // Token is invalid or expired
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
    }
}
