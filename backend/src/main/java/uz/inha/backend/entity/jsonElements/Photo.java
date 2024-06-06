package uz.inha.backend.entity.jsonElements;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Photo extends BaseEntity{
    @ManyToOne
    private Album album;
    private String title;
    private String url;
    private String thumbnailUrl;
}
