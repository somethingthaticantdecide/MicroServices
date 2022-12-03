package edu.school21.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/covid-management/countries")
public class CovidController {
    @Value("${application.api}")
    public String COVID_REST_API;
    @Value("${api.key}")
    public String API_KEY;
    @Value("${api.host}")
    public String API_HOST;
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public ResponseEntity<String> getAll() {
        try {
            return getResponse(COVID_REST_API);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> getCountryData(@PathVariable String name) {
        try {
            return getResponse(COVID_REST_API + "/" + name);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    private ResponseEntity<String> getResponse(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("X-RapidAPI-Key", API_KEY);
        headers.set("X-RapidAPI-Host", API_HOST);
        HttpEntity<String> httpEntity = new HttpEntity<>("some body", headers);
        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class); // return restTemplate.getForEntity(url, String.class);
    }
}
