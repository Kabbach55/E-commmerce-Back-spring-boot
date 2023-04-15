package ma.ecom.ecom.back.dao;

import ma.ecom.ecom.back.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface ProductRepo extends JpaRepository<Product,Long> {
    Product findByRefContaining (String ref);
    Product findByDescriptionContainingIgnoreCase(String description);

}
