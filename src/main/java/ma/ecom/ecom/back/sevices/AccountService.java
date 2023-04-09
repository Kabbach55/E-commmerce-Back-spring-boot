package ma.ecom.ecom.back.sevices;

import ma.ecom.ecom.back.entities.User;

import java.util.List;

public interface AccountService {
    User addNewUser(User user);
    User loadUserByUsername (String username);
    List<User> listUsers();
}
