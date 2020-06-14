package by.palgogo.todolist.service.impl;

import by.palgogo.todolist.domain.Task;
import by.palgogo.todolist.repository.TaskRepository;
import by.palgogo.todolist.service.TaskService;
import by.palgogo.todolist.service.dto.TaskDTO;
import by.palgogo.todolist.service.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskDTO createTask(Task task) {
        Task save = taskRepository.save(task);
        return taskMapper.toDTO(save);
    }

    public Optional<TaskDTO> getTaskById(Long id) {
        return taskRepository.findById(id).map(taskMapper::toDTO);
    }

    public List<TaskDTO> getAllTasks() {
        return taskMapper.taskToTaskDTOs(taskRepository.findAll());
    }

    public List<TaskDTO> getAllTasksInCategory(Long categoryId) {
        return taskMapper.taskToTaskDTOs(taskRepository.findByCategory_Id(categoryId));
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public Task changeTaskStatus(Long id) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setDoneStatus(!task.getDoneStatus());
                    return taskRepository.save(task);
                }).orElseThrow();
    }
}
