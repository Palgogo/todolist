package by.palgogo.todolist.repository;

import by.palgogo.todolist.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByCategory_Id(Long categoryId);
    List<Task> findAllByDoneStatusFalse();
}
