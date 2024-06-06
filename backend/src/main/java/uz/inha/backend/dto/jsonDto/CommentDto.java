package uz.inha.backend.dto.jsonDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {
    private Integer postId;
    private Integer id;
    private String name;
    private String email;
    private String body;
}
