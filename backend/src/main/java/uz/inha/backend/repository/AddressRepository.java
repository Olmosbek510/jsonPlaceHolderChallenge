package uz.inha.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.inha.backend.entity.jsonElements.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}