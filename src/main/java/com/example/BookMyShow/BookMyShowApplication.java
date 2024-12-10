package com.example.BookMyShow;

import com.example.BookMyShow.controller.UserController;
import com.example.BookMyShow.dtos.SignInRequestDto;
import com.example.BookMyShow.dtos.SignUpRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {

	@Autowired
	private UserController userController;

	public static void main(String[] args) {

		SpringApplication.run(BookMyShowApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		SignUpRequestDto signUpRequestDto = new SignUpRequestDto();
//		signUpRequestDto.setEmail("rsr2173@gmail.com");
//		signUpRequestDto.setPassword("Ramesh@99");
//		signUpRequestDto.setName("Ramesh");

//		userController.signUp(signUpRequestDto);

		SignInRequestDto signInRequestDto = new SignInRequestDto();

		signInRequestDto.setEmail("rsr2173@gmail.com");
		signInRequestDto.setPassword("Ramesh@9956");
		userController.signIn(signInRequestDto);
	}
}