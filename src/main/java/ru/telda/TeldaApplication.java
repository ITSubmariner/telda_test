package ru.telda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class TeldaApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeldaApplication.class, args);
    }
}
