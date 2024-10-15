package com.sparta.nbcpersonalprojecttodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NbcPersonalProjectTodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NbcPersonalProjectTodoApplication.class, args);
    }

}
