package by.palgogo.todolist.service.impl;

import by.palgogo.todolist.domain.Task;
import by.palgogo.todolist.repository.TaskRepository;
import by.palgogo.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getAllTasksInCategory(Long categoryId) {
        return taskRepository.findByCategory_Id(categoryId);
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
