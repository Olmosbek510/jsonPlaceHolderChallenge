package uz.inha.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.inha.backend.entity.jsonElements.Todo;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findTodoByUserId(Integer userId);
}