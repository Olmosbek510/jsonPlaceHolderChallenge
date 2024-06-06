package uz.inha.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.inha.backend.entity.jsonElements.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findCommentByPostId(Integer postId);
}