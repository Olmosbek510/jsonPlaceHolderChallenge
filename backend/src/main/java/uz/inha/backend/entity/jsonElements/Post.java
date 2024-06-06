package uz.inha.backend.entity.jsonElements;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post extends BaseEntity{
    @ManyToOne
    private UserJson user;
    private String title;
    private String body;
}
