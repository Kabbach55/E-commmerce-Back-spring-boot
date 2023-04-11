package ma.ecom.ecom.back.dao;

import ma.ecom.ecom.back.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface CartRepo extends JpaRepository<Cart,Long> {
}
