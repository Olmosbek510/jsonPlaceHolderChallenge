package uz.inha.backend.entity.jsonElements;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.inha.backend.entity.User;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Album extends BaseEntity{
    @ManyToOne
    private UserJson user;
    private String title;
}
