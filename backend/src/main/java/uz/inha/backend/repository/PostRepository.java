package uz.inha.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.inha.backend.entity.jsonElements.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findPostByUserId(Integer userid);
}