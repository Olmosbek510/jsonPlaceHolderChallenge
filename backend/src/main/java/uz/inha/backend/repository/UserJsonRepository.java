package uz.inha.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.inha.backend.entity.jsonElements.UserJson;

public interface UserJsonRepository extends JpaRepository<UserJson, Integer> {
}