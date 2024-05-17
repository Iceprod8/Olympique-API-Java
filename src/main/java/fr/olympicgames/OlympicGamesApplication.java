package fr.olympicgames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import fr.olympicgames.config.SecurityConfig;

@SpringBootApplication
@Import(SecurityConfig.class)
public class OlympicGamesApplication {

    public static void main(String[] args) {
        SpringApplication.run(OlympicGamesApplication.class, args);
    }
}
