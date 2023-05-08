package com.xbal.app.jackgames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JackGamesApplication {

	public static void main(String[] args) {
		SpringApplication.run(JackGamesApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return String.format("Welcome to JackGames");
	}
}
