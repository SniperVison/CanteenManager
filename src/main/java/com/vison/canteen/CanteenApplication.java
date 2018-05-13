package com.vison.canteen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class CanteenApplication {

	public static void main(String[] args) {
		SpringApplication.run(CanteenApplication.class, args).registerShutdownHook();
	}
}
