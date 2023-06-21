package ma.ecom.ecom.back.dao;

import ma.ecom.ecom.back.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

@RestResource
public interface ProductRepo extends JpaRepository<Product,Long> {
    Product findByRef (String ref);
    Optional<Product> findById(Long id);
}
