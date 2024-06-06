package uz.inha.backend.service.jsonObjectsService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.inha.backend.dto.jsonDto.PostDto;
import uz.inha.backend.entity.jsonElements.Post;
import uz.inha.backend.repository.PostRepository;
import uz.inha.backend.repository.UserJsonRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserJsonRepository userJsonRepository;

    public void saveAll(List<PostDto> postDtos) {
        postDtos.forEach(postDto -> {
            postRepository.save(new Post(
                    userJsonRepository.findById(postDto.getUserId()).orElseThrow(),
                    postDto.getTitle(),
                    postDto.getBody()
                    ));
        });
    }

    public List<Post> findByUserId(Integer userid) {
        return postRepository.findPostByUserId(userid);
    }
}
