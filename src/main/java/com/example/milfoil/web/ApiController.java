package com.example.milfoil.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "ok");
    }

    @GetMapping("/profile")
    public Map<String, Object> profile() {
        return Map.of(
                "user", "demo-user",
                "role", "viewer",
                "status", "active"
        );
    }
}
