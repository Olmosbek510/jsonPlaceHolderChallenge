package uz.inha.backend.entity.jsonElements;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UserJson extends BaseEntity {
    private String name;
    private String username;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    private String phone;
    private String website;
    @ManyToOne(cascade = CascadeType.ALL)
    private Company company;
}
