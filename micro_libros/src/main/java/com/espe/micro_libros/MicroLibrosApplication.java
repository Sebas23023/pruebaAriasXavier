package com.espe.micro_libros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MicroLibrosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroLibrosApplication.class, args);
    }
}
