package ma.ecom.ecom.back.dao;

import ma.ecom.ecom.back.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
