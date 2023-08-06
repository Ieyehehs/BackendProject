package com.example.backend;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.backend")
@EnableJpaRepositories(basePackages = "com.example.backend")
public class BackendAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendAppApplication.class, args);
    }
    
}

