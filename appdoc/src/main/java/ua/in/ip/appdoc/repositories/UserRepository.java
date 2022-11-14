package ua.in.ip.appdoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.in.ip.appdoc.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}