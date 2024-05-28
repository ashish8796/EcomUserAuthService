package dev.ashish.EcomUserAuthService;

import dev.ashish.EcomUserAuthService.dto.RoleResponseDTO;
import dev.ashish.EcomUserAuthService.entity.Role;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EcomUserAuthServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(EcomUserAuthServiceApplication.class, args);

//		List<Role> roles = new ArrayList<>();
//		Role role1 = new Role();
//		Role role2 = new Role();
//		Role role3 = new Role();
//
//		roles.add(role1);
//		roles.add(role2);
//		roles.add(role3);
//
//		List<RoleResponseDTO> newRoles = roles.stream().map(RoleResponseDTO::from).toList();
//
//		System.out.println(newRoles);

	}
}
