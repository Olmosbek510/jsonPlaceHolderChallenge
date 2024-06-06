package uz.inha.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.inha.backend.entity.jsonElements.Todo;
import uz.inha.backend.service.jsonObjectsService.TodoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService todoService;
    @GetMapping("/filter")
    public ResponseEntity<List<Todo>> getPosts(@RequestParam("userId") Integer userId){
        List<Todo> todos = todoService.findByUserId(userId);
        return ResponseEntity.ok(todos);
    }
}
