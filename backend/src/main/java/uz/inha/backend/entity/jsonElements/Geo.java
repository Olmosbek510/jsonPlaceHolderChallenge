package uz.inha.backend.entity.jsonElements;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Geo extends BaseEntity{
    private Integer id;
    private String lat;
    private String lng;
}
