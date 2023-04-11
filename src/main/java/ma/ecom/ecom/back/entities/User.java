package ma.ecom.ecom.back.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor@AllArgsConstructor
@Table(name = "_User") @Data
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String username;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;
    private String city;
    private String phone;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType userType;


}
