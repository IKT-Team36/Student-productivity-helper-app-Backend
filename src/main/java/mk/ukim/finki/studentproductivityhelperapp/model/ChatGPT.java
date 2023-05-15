package mk.ukim.finki.studentproductivityhelperapp.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ChatGPT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long DataId;
    @Column(length = 500)
    private String Data;
    @ManyToOne
    private Course course;
    public ChatGPT() {

    }

    public ChatGPT(Long dataId, String data) {
        DataId = dataId;
        Data = data;
    }
}
