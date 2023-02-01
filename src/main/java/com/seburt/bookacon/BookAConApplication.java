package com.seburt.bookacon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.seburt.bookacon.core"})
@EnableJpaRepositories(basePackages = "com.seburt.bookacon.core")
@ComponentScan(value = {
        "com.seburt.bookacon.core",
        "com.seburt.bookacon.api"
})
public class BookAConApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookAConApplication.class, args);
    }

}
