package by.palgogo.todolist.web.rest;

import by.palgogo.todolist.domain.Task;
import by.palgogo.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Transactional
public class TaskResource {

    @Autowired
    private TaskService taskService;


    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("tasks/{id}")
    public ResponseEntity<?> getTask(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        return (ResponseEntity<?>) task.map((response) -> ((ResponseEntity.BodyBuilder) ResponseEntity.ok().body(response)))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @GetMapping("tasks/category/{categoryId}")
    public List<Task> getCategoryTasks(@PathVariable Long categoryId) {
        return taskService.getAllTasksInCategory(categoryId);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) throws URISyntaxException {
        Task result = taskService.createTask(task);

        return ResponseEntity.created(new URI("api/tasks/" + result.getId()))
                .body(result);
    }

    @PatchMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTaskStatus(@PathVariable Long id) {
        Task responseEntity = null;

        try {
            responseEntity = taskService.changeTaskStatus(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(responseEntity);
    }

}
