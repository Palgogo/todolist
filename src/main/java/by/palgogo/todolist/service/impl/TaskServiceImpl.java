package by.palgogo.todolist.service.impl;

import by.palgogo.todolist.domain.Task;
import by.palgogo.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> getTaskById(Long id){
        Optional<Task> optionalTask = taskRepository.findById(id);

        return optionalTask;
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

    public void completeTask(Task task){
        Optional<Task> optionalTask = taskRepository.findById(task.getId());
        optionalTask.ifPresent(task1 -> {
            task1.setDoneStatus(true);
            taskRepository.save(task1);
        });
    }
}
