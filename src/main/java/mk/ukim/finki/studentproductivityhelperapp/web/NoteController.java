package mk.ukim.finki.studentproductivityhelperapp.web;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import mk.ukim.finki.studentproductivityhelperapp.model.Attachment;
import mk.ukim.finki.studentproductivityhelperapp.model.Note;
import mk.ukim.finki.studentproductivityhelperapp.model.User;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.NoteDto;
import mk.ukim.finki.studentproductivityhelperapp.service.NoteService;
import mk.ukim.finki.studentproductivityhelperapp.service.UserService;
import mk.ukim.finki.studentproductivityhelperapp.service.token.JwtTokenUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:7762")
@RequestMapping(path = "/api/v1/note",
        method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@AllArgsConstructor
public class NoteController {

    private NoteService noteService;
    private JwtTokenUtil jwtTokenUtil;
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Note> findById(@PathVariable Long id) {
        return this.noteService.findById(id)
                .map(note -> ResponseEntity.ok().body(note))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/allNotes")
    public List<Note> listNotes(){
        return this.noteService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Note> save(@RequestBody NoteDto noteDto, HttpServletRequest request) {
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentEmail = (String) authentication.getPrincipal();
//
//        System.out.println("Current email");
//        System.out.println(currentEmail);
//        System.out.println("Save note controller");
//        HttpSession session = request.getSession();
//        String token = (String) session.getAttribute("token");
//
//        String email = this.jwtTokenUtil.extractUsername(token);
//        User user = (User) this.userService.loadUserByUsername(email);
//        System.out.println("Print email from loaded user");
//        System.out.println(user.getEmail());

        return this.noteService.save(noteDto)
                .map(note -> ResponseEntity.ok().body(note))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Note> edit(@PathVariable Long id, @RequestBody NoteDto noteDto) {
        return this.noteService.edit(id, noteDto)
                .map(note -> ResponseEntity.ok().body(note))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        this.noteService.delete(id);
    }

//    @GetMapping("/all")
//    public List<Note> listAll(HttpServletRequest request) {
//
//        HttpSession session = request.getSession();
//        String token = (String) session.getAttribute("token");
//        String email = this.jwtTokenUtil.extractUsername(token);
//        User user = (User) this.userService.loadUserByUsername(email);
//        System.out.println(user.getEmail());
//        System.out.println(user.getFirstName());
//        System.out.println("Print email from loaded user");
//        System.out.println(user.getEmail());
//
//        System.out.println("Token form note controller");
//        System.out.println(token);
//        return this.noteService.findAll();
//    }


}
