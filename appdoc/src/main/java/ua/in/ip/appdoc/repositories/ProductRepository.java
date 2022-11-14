package ua.in.ip.appdoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.in.ip.appdoc.models.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);
}
