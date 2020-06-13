package by.palgogo.todolist.service;

import by.palgogo.todolist.domain.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task createTask(Task task);

    Optional<Task> getTaskById(Long id);

    List<Task> getAllTasks();

    List<Task> getAllTasksInCategory(Long categoryId);

    void deleteTask(Long taskId);

    Task changeTaskStatus(Long id);
}
