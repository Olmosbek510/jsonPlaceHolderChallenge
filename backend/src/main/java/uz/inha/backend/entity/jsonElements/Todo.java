package uz.inha.backend.entity.jsonElements;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Todo extends BaseEntity{
    @ManyToOne
    private UserJson user;
    private String title;
    private boolean completed;
}
