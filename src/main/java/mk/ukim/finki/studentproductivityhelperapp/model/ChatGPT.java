package mk.ukim.finki.studentproductivityhelperapp.model;


import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Data
@Entity
public class ChatGPT {

    @Id
    private Long DataId;
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
