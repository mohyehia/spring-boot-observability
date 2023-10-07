package com.moh.yehia.observability.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
@Log4j2
@RequiredArgsConstructor
public class ProductController {
    private final RestTemplate restTemplate;

    @GetMapping
    public List<Product> findAll() {
        log.info("ProductController :: findAll :: start");
        return Arrays.asList(
                new Product(UUID.randomUUID().toString(), "Random Product Name", 5),
                new Product(UUID.randomUUID().toString(), "Second Random Product", 10),
                new Product(UUID.randomUUID().toString(), "Last Product Name", 15)
        );
    }

    @GetMapping("/trace")
    public String trace() {
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("https://httpbin.org/post", "Hello, Actuator", String.class);
        return responseEntity.getBody();
    }
}

record Product(String id, String name, int stock) {
}