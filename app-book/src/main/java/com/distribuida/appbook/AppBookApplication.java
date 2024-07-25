package com.distribuida.appbook;

<<<<<<< HEAD
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
=======
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
>>>>>>> main
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
<<<<<<< HEAD
=======
@EnableAdminServer
>>>>>>> main
public class AppBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppBookApplication.class, args);
    }

}
