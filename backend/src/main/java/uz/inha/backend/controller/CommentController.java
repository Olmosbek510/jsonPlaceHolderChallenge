package uz.inha.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.inha.backend.entity.jsonElements.Comment;
import uz.inha.backend.service.jsonObjectsService.CommentService;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @GetMapping("/filter")
    public ResponseEntity<List<Comment>> getCommentsByPost(@RequestParam("postId")Integer postId){
        return ResponseEntity.ok(commentService.findByPostId(postId));
    }
}
