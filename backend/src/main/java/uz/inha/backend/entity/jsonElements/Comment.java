package uz.inha.backend.entity.jsonElements;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment extends BaseEntity{
    @ManyToOne
    private Post post;
    @Column(length = 500)
    private String name;
    private String email;
    @Column(length = 1000)
    private String body;
}
