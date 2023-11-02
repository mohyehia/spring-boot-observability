package com.moh.yehia.observability.config;

import com.moh.yehia.observability.model.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Component
@RequiredArgsConstructor
@Log4j2
public class PostApiHealthIndicator implements HealthIndicator {
    private static final String URL = "https://jsonplaceholder.typicode.com/posts";
    private final RestTemplate restTemplate;

    @Override
    public Health health() {
        try {
            ResponseEntity<Post[]> response = restTemplate.getForEntity(URL, Post[].class);
            if (response.getStatusCode() == HttpStatus.OK) {
                return Health.up().build();
            } else {
                return Health.down()
                        .withDetail("ping_url", URL)
                        .withDetail("ping_time", new Date())
                        .build();
            }
        } catch (RestClientException e) {
            log.error(e.getMessage(), e);
            return Health.down()
                    .withDetail("ping_url", URL)
                    .withDetail("ping_time", new Date())
                    .build();
        }
    }
}
