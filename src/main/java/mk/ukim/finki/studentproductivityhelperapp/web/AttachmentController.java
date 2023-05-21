package mk.ukim.finki.studentproductivityhelperapp.web;


import lombok.AllArgsConstructor;
import mk.ukim.finki.studentproductivityhelperapp.model.Attachment;
import mk.ukim.finki.studentproductivityhelperapp.model.ToDo;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.AttachmentDto;
import mk.ukim.finki.studentproductivityhelperapp.service.AttachmentService;
import mk.ukim.finki.studentproductivityhelperapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:7762")
@RequestMapping(path = "/api/v1/attachment")
@AllArgsConstructor
public class AttachmentController {

    private AttachmentService attachmentService;

    @GetMapping("/allAttachments")
    public List<Attachment> findAll() {
        return this.attachmentService.listAttachments();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Attachment> findById(@PathVariable Long id) {
        return this.attachmentService.findById(id)
                .map(attachment -> ResponseEntity.ok().body(attachment))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Attachment> save(@RequestBody AttachmentDto attachmentDto) {
        return this.attachmentService.save(attachmentDto)
                .map(attachment -> ResponseEntity.ok().body(attachment))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Attachment> save(@PathVariable Long id, @RequestBody AttachmentDto attachmentDto) {
        return this.attachmentService.edit(id, attachmentDto)
                .map(attachment -> ResponseEntity.ok().body(attachment))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.attachmentService.deleteById(id);
        if(this.attachmentService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

}
