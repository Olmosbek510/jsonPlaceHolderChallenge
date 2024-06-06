package uz.inha.backend.dto.jsonDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDto {
    private Integer userId;
    private Integer id;
    private String title;
}
