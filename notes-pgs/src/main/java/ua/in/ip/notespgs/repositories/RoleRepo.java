package ua.in.ip.notespgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.in.ip.notespgs.entityes.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
}