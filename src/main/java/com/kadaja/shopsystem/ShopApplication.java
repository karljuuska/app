package com.kadaja.shopsystem;

import com.kadaja.shopsystem.service.ShopService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShopApplication {

	private final ShopService shopService;

	public ShopApplication(ShopService shopService) {
		this.shopService = shopService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	@Bean
	public ApplicationRunner init() {
		return args -> {

			shopService.persistIngredients();
		};
	}
}
