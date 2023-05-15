package com.xbal.app.jackgames.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.xbal.app.jackgames.database.GameRepository;

@Configuration
@EnableJpaRepositories(basePackages = "com.xbal.app.jackgames.database")
public class GameConfig {
    
    // Define a method to create an instance of GameRepository
    @Bean
    public GameRepository gameRepository() {
        // Return a new instance of GameRepository
        return new GameRepository();
    }
}
