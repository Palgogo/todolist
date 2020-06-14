package by.palgogo.todolist.service;

import by.palgogo.todolist.domain.Task;
import by.palgogo.todolist.service.dto.TaskDTO;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    TaskDTO createTask(Task task);

    Optional<Task> getTaskById(Long id);

    List<TaskDTO> getAllTasks();

    List<TaskDTO> getAllTasksInCategory(Long categoryId);

    void deleteTask(Long taskId);

    Task changeTaskStatus(Long id);
}
