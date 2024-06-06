package uz.inha.backend.service.jsonObjectsService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.inha.backend.dto.jsonDto.TodoDto;
import uz.inha.backend.entity.jsonElements.Todo;
import uz.inha.backend.entity.jsonElements.UserJson;
import uz.inha.backend.repository.TodoRepository;
import uz.inha.backend.repository.UserJsonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final UserJsonRepository userJsonRepository;
    public void saveAll(List<TodoDto> todoDtos) {
       todoDtos.forEach(todoDto -> {
           UserJson userJson = userJsonRepository.findById(todoDto.getUserId()).orElseThrow();
           todoRepository.save(new Todo(userJson, todoDto.getTitle(), todoDto.isCompleted()));
       });
    }

    public List<Todo> findByUserId(Integer userId) {
        return todoRepository.findTodoByUserId(userId);
    }
}
