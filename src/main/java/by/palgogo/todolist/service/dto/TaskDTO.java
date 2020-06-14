package by.palgogo.todolist.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDTO {

    private Long id;
    private String description;
    private Boolean doneStatus;
    private Long categoryId;
}
