
package ma.ecom.ecom.back.controllers;

        import ma.ecom.ecom.back.dao.UserRepo;
        import ma.ecom.ecom.back.entities.User;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;
        import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UsersController {
    private final UserRepo userRepo;

    public UsersController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping()
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userRepo.findById(id);
    }

    @PostMapping("/add")
    public User createUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id: " + id));

        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        // Set other fields as needed

        return userRepo.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
    }
}
