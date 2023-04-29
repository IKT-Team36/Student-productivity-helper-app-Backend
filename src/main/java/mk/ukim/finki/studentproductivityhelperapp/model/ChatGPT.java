package mk.ukim.finki.studentproductivityhelperapp.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
