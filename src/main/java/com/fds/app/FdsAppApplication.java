package com.fds.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.fds.app.repository")
public class FdsAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FdsAppApplication.class, args);
    }

}
