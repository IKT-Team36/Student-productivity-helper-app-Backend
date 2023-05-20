package mk.ukim.finki.studentproductivityhelperapp.model.dto;

import lombok.Data;

@Data
public class LogDto {

    private String logContent;
    private Long user;
    private Long course;

}
