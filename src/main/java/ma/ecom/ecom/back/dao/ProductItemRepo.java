package ma.ecom.ecom.back.dao;

import ma.ecom.ecom.back.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface ProductItemRepo extends JpaRepository<ProductItem,Long> {
}
