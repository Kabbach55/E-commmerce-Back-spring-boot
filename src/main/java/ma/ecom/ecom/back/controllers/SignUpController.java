package ma.ecom.ecom.back.controllers;


import ma.ecom.ecom.back.dto.SignUpDTO;
import ma.ecom.ecom.back.dto.UserDTO;
import ma.ecom.ecom.back.sevices.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {
    @Autowired
    private AuthenticationService authenticationService ;
    @PostMapping("/sign-up")
    public ResponseEntity<?> signUpUser(@RequestBody SignUpDTO signUpDTO){

        if(authenticationService.hasUserWithEmail(signUpDTO.getEmail()))
            return new ResponseEntity<>("User already exist",HttpStatus.NOT_ACCEPTABLE);
        UserDTO createdUser  = authenticationService.createUser(signUpDTO);
        if (createdUser == null)
            return  new ResponseEntity<>("User not created", HttpStatus.NOT_ACCEPTABLE);
        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);

    }
}
