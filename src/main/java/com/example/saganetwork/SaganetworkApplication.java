package com.example.saganetwork;

import com.example.saganetwork.Entity.Role;
import com.example.saganetwork.Entity.User;
import com.example.saganetwork.service.QuestionService;
import com.example.saganetwork.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
		(exclude = {
				org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
		)
public class SaganetworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaganetworkApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService, QuestionService questionService){
		return  args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_TEACHER"));

			userService.saveUser(new User(null, "will", "will@gmail.com", "1234will", new ArrayList<>(),new ArrayList<>(),null,null));
			userService.saveUser(new User (null, "jhon", "jhon@gmail.com", "1234jhon", new ArrayList<>(),new ArrayList<>(),null,null));



			userService.addRoleToUser("will", "ROLE_TEACHER");
			userService.addRoleToUser("jhon", "ROLE_USER");

		};
	}

}
