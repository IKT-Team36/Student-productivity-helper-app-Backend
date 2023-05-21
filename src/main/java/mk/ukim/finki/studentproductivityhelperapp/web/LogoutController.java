package mk.ukim.finki.studentproductivityhelperapp.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/logout")
public class LogoutController {

    @GetMapping
    public ResponseEntity<Void> logout(HttpServletRequest request) {
        // Clear session
        request.getSession().invalidate();

        // Invalidate token (example: remove token from response headers)
//        response.setHeader("Authorization", "");

        return ResponseEntity.ok().build();
    }
}
