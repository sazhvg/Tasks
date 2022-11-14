package ua.in.ip.appdoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.in.ip.appdoc.models.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}