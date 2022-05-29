package com.fds.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.fds.app.repository")
public class FdsAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FdsAppApplication.class, args);
    }

}
