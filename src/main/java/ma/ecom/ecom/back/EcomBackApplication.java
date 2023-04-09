package ma.ecom.ecom.back;

import ma.ecom.ecom.back.entities.User;
import ma.ecom.ecom.back.entities.UserType;
import ma.ecom.ecom.back.sevices.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcomBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomBackApplication.class, args);

	}
	@Bean
	CommandLineRunner start(AccountService accountService){
		return args -> {
			accountService.addNewUser(new User(null,"zakaria","zakaria","kabbach","","","","", UserType.ADMIN));

		};
	}


}
