package com.vinceip.GameCollectionManager;

import com.vinceip.GameCollectionManager.CLI.GameCollectionManagerCLI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GameCollectionManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameCollectionManagerApplication.class, args);
		GameCollectionManagerCLI cli = new GameCollectionManagerCLI();
		cli.run();
	}

	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
