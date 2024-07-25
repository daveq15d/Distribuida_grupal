package com.distribuida.appbook.clients;


import com.distribuida.appbook.dtos.AutorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Component
public class AuthorRestClient {

    private final WebClient webClient;

    public AuthorRestClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<AutorDto> findById(Integer id){
        return webClient.get()
                .uri("/authors/{id}",id)
                .retrieve()
                .bodyToMono(AutorDto.class);
    }

}
