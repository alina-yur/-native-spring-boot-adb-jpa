package com.example.graalvm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TranslationRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                log.info("Loading initial data");

                var translations = List.of(
                        new Translation("Thank you", "Merci vielmal"),
                        new Translation("Have a nice meal", "En guete!"),
                        new Translation("Goodbye", "Ade"),
                        new Translation("Bread", "Brötli"),
                        new Translation("Cat", "Büsi"));

                repository.saveAll(translations);
            }
        };
    }
}
