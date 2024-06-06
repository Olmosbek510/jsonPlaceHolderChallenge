package uz.inha.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.inha.backend.entity.Role;
import uz.inha.backend.entity.enums.RoleName;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findRoleByRoleName(RoleName roleName);
}