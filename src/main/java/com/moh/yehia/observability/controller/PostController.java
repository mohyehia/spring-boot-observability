package com.moh.yehia.observability.controller;

import com.moh.yehia.observability.model.Post;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
@Log4j2
public class PostController {
    private final RestTemplate restTemplate;
    private static final String URL = "https://jsonplaceholder.typicode.com/posts";

    @GetMapping
    @Timed("posts.findAll.time")
    public Post[] findAll() {
        ResponseEntity<Post[]> response = restTemplate.getForEntity(URL, Post[].class);
        return response.getBody();
    }

    @PostMapping
    @Timed("posts.save.time")
    public Post save(@RequestBody Post post) {
        ResponseEntity<Post> response = restTemplate.postForEntity(URL, post, Post.class);
        return response.getBody();
    }

    @GetMapping("/{postId}")
    @Timed("posts.findById.time")
    public Post findById(@PathVariable("postId") int postId) {
        Map<String, String> params = new HashMap<>();
        params.put("postId", String.valueOf(postId));
        ResponseEntity<Post> response = restTemplate.getForEntity(URL + "/{postId}", Post.class, params);
        return response.getBody();
    }

    @PutMapping("/{postId}")
    @Timed("posts.update.time")
    public Post update(@PathVariable("postId") int postId, @RequestBody Post post) {
        Map<String, String> params = new HashMap<>();
        params.put("postId", String.valueOf(postId));
        restTemplate.put(URL + "/{postId}", post, params);
        return post;
    }

    @DeleteMapping("/{postId}")
    @Timed("posts.deleteById.time")
    public void deleteById(@PathVariable("postId") int postId) {
        Map<String, String> params = new HashMap<>();
        params.put("postId", String.valueOf(postId));
        restTemplate.delete(URL + "/{postId}", params);
    }
}
