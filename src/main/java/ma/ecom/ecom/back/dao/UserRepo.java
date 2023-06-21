package ma.ecom.ecom.back.dao;

import ma.ecom.ecom.back.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RestResource
public interface UserRepo extends JpaRepository<User,Long> {
    Optional <User> findByUsername(String username);

    User findByUserEmail(String email);
}
