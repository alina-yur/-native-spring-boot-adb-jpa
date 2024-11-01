package com.example.graalvm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner showTranslations(TranslationRepository repository) {
        return args -> {
            log.info("\nTranslations:");
            log.info("------------");
            repository.findAll()
                    .forEach(t -> log.info(String.format("%-20s -> %s", t.getEnglish(), t.getTranslation())));
            log.info("------------\n");
        };
    }
}