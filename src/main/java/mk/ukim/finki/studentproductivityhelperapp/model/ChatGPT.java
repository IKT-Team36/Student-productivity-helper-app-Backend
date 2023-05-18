package mk.ukim.finki.studentproductivityhelperapp.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ChatGPT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dataId;
    @Column(length = 500)
    private String data;
    @ManyToOne
    private Course course;
    public ChatGPT() {

    }

    public ChatGPT(String data) {
        this.data = data;
    }

    public ChatGPT(String data, Course course) {
        this.data = data;
        this.course = course;
    }
}
