package uz.inha.backend.service.jsonObjectsService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.inha.backend.dto.jsonDto.CommentDto;
import uz.inha.backend.entity.jsonElements.Comment;
import uz.inha.backend.entity.jsonElements.Post;
import uz.inha.backend.repository.CommentRepository;
import uz.inha.backend.repository.PostRepository;
import uz.inha.backend.repository.UserJsonRepository;

import java.util.List;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    public void saveAll(List<CommentDto> commentDtos) {
        commentDtos.forEach(commentDto -> {
            commentRepository.save(new Comment(
                    postRepository.findById(commentDto.getPostId()).orElseThrow(),
                    commentDto.getName(),
                    commentDto.getEmail(),
                    commentDto.getBody()
            ));
        });
    }

    public List<Comment> findByPostId(Integer postId) {
        return commentRepository.findCommentByPostId(postId);
    }
}
