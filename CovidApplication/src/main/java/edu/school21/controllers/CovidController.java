package edu.school21.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/covid-management/countries")
public class CovidController {
    @Value("${application.api}")
    public String COVID_REST_API;
    public final String COUNTRIES = "/countries/";
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/all")
    public ResponseEntity<String> getAll() {
        try {
            return restTemplate.getForEntity(COVID_REST_API + COUNTRIES, String.class);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<String> getCountryData(@PathVariable String name) {
        try {
            return restTemplate.getForEntity(COVID_REST_API + COUNTRIES + name, String.class);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
