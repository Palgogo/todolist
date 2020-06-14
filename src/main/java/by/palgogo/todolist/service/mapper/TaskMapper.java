package by.palgogo.todolist.service.mapper;

import by.palgogo.todolist.domain.Task;
import by.palgogo.todolist.service.dto.TaskDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface TaskMapper {

    @Mapping(source = "category.id", target = "categoryId")
    TaskDTO toDTO(Task task);

    @InheritInverseConfiguration
    Task toTask(TaskDTO taskDTO);

    List<TaskDTO> taskToTaskDTOs(List<Task> tasks);
}
