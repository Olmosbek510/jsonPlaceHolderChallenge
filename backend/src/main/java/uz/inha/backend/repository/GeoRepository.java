package uz.inha.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.inha.backend.entity.jsonElements.Geo;

public interface GeoRepository extends JpaRepository<Geo, Integer> {
}