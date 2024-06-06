package uz.inha.backend.entity.jsonElements;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company extends BaseEntity{
    private String name;
    private String catchPhrase;
    private String bs;
}
