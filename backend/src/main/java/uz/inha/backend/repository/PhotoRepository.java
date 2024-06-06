package uz.inha.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.inha.backend.entity.jsonElements.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {
}