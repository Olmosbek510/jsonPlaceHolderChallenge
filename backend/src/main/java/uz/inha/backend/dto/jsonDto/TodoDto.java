package uz.inha.backend.dto.jsonDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoDto {
    private Integer userId;
    private Integer id;
    private String title;
    private boolean completed;
}
