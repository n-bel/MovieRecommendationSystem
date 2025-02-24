package com.mrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.mrs.repository")
public class MovieRecommendationSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieRecommendationSystemApplication.class, args);
    }

}
