package uz.inha.backend.entity.jsonElements;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address extends BaseEntity{
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    @OneToOne(cascade = CascadeType.ALL)
    private Geo geo;
}
