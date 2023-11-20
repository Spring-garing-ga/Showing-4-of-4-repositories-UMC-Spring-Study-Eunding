package com.example.umcweek7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // JpaAuditing 사용이 가능하도록
public class UmcWeek7Application {

    public static void main(String[] args) {
        SpringApplication.run(UmcWeek7Application.class, args);
    }

}
