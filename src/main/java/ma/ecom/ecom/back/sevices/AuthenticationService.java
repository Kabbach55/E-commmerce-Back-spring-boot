package ma.ecom.ecom.back.sevices;

import ma.ecom.ecom.back.dao.UserRepo;
import ma.ecom.ecom.back.dto.SignUpDTO;
import ma.ecom.ecom.back.dto.UserDTO;
import ma.ecom.ecom.back.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AuthenticationService {
   @Autowired
    private UserRepo userRepo ;


    public UserDTO createUser(SignUpDTO signUpDTO) {
        User user =new User();
        user.setEmail(signUpDTO.getEmail());
        user.setUsername(signUpDTO.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(signUpDTO.getPassword()));
        userRepo.save(user);
        if(user==null)
            return null;
        return user.mapUserToUserDto();
    }

    public boolean hasUserWithEmail(String email) {
    return userRepo.findByUserEmail(email) != null;
    }

    public void authenticate(UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) {
    }
}
