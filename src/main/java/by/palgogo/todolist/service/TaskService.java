package by.palgogo.todolist.service;

import by.palgogo.todolist.service.dto.TaskDTO;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    TaskDTO createTask(TaskDTO taskDTO);

    Optional<TaskDTO> getTaskById(Long id);

    List<TaskDTO> getAllTasks();

    List<TaskDTO> getAllTasksInCategory(Long categoryId);

    void deleteTask(Long taskId);

    TaskDTO changeTaskStatus(Long id);
}
