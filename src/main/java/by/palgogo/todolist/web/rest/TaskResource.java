package by.palgogo.todolist.web.rest;

import by.palgogo.todolist.service.TaskService;
import by.palgogo.todolist.service.dto.TaskDTO;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@RequestMapping("/api")
@Transactional
public class TaskResource {

    private final TaskService taskService;

    @GetMapping("/tasks")
    public List<TaskDTO> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("tasks/{id}")
    public ResponseEntity<?> getTask(@PathVariable Long id) {
        Optional<TaskDTO> task = taskService.getTaskById(id);
        return task
                .map((response) -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @GetMapping("tasks/category/{categoryId}")
    public List<TaskDTO> getCategoryTasks(@PathVariable Long categoryId) {
        return taskService.getAllTasksInCategory(categoryId);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/tasks")
    public ResponseEntity<TaskDTO> createTask(@Valid @RequestBody TaskDTO taskDTO) throws URISyntaxException {
        TaskDTO result = taskService.createTask(taskDTO);

        return ResponseEntity.created(new URI("api/tasks/" + result.getId()))
                .body(result);
    }

    @PatchMapping("/tasks/{id}")
    public ResponseEntity<TaskDTO> updateTaskStatus(@PathVariable Long id) {
        TaskDTO responseEntity = null;

        try {
            responseEntity = taskService.changeTaskStatus(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(responseEntity);
    }

}
