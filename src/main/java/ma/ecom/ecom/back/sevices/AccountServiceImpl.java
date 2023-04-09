package ma.ecom.ecom.back.sevices;

import ma.ecom.ecom.back.dao.UserRepo;
import ma.ecom.ecom.back.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    UserRepo userRepo;
    @Override
    public User addNewUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User loadUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> listUsers() {
        return userRepo.findAll();
    }
}
