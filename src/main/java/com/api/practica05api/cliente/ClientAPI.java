package com.api.practica05api.cliente;

import com.api.practica05api.modelos.Piloto;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class ClientAPI {
    private static WebClient webClient = WebClient.create("http://localhost:8080");
    public static void main(String[] args) {

        Mono<Piloto> createdProduct = findAll();
        createdProduct.subscribe(System.out::println);


    }

    public static Mono<Piloto> findAll() {
        return webClient.get()
                .uri("/api/pilotos")
                .retrieve()
                .bodyToMono(Piloto.class);
    }
}