package ma.ecom.ecom.back.sevices;

import ma.ecom.ecom.back.dao.UserRepo;
import ma.ecom.ecom.back.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo ;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
          User user =userRepo.findByUserEmail(email);
          if(user == null)
              throw new UsernameNotFoundException("Username not found",null);
              return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),new ArrayList<>());


    }
}
