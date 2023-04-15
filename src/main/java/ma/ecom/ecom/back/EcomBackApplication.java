package ma.ecom.ecom.back;

import ma.ecom.ecom.back.dao.ProductRepo;
import ma.ecom.ecom.back.entities.Product;
import ma.ecom.ecom.back.entities.User;
import ma.ecom.ecom.back.entities.UserType;
import ma.ecom.ecom.back.sevices.AccountService;
import ma.ecom.ecom.back.sevices.ProductService;
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
	CommandLineRunner start(AccountService accountService , ProductService productService , ProductRepo productRepo){
		return args -> {
			accountService.addNewUser(new User(null,"zakaria","zakaria","kabbach","","","","", UserType.ADMIN));
			productService.addNewProduct(new Product(null,"p1","Iphone 14 pro max",null, 15000));
			System.out.println(accountService.listUsers());
			System.out.println(productRepo.findByDescriptionContainingIgnoreCase("iphone"));

		};
	}


}
