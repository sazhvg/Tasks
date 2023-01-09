package ua.in.ip.notespgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.in.ip.notespgs.entityes.User;

@Repository
public interface UserRepo extends JpaRepository <User, Long> {
    User findByUsername(String username);
}
