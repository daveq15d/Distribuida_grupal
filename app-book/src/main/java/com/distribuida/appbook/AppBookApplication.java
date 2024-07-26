package com.distribuida.appbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@EnableAdminServer
public class AppBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppBookApplication.class, args);
    }

}
