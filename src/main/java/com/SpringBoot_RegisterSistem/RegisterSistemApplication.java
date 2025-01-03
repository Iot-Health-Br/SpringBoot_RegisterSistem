package com.SpringBoot_RegisterSistem;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RegisterSistemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterSistemApplication.class, args);
	}

	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("API")
						.description("Documentação da API")
						.version("v1.1"));
	}
}
