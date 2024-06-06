package uz.inha.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.inha.backend.entity.jsonElements.Post;
import uz.inha.backend.service.jsonObjectsService.PostService;

import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @GetMapping
    public Map<String, String> getPosts(){
        return Map.of("Phone","Samsung");
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Post>> getPostsByUser(@RequestParam(name = "userid") Integer userid){
        List<Post> posts = postService.findByUserId(userid);
        return ResponseEntity.ok(posts);
    }
}
