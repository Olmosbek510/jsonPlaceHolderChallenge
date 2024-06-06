package uz.inha.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.inha.backend.entity.jsonElements.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}