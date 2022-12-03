package edu.school21.countriesapplication.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/countries-management/countries")
public class CountryController {
    @Value("${application.api}")
    public String HTTPS_RESTCOUNTRIES_COM_V_3_1;
    public static final String NAME = "/name/";
    public static final String ALL = "/all";
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public ResponseEntity<String> getAll() {
        try {
            return restTemplate.getForEntity(HTTPS_RESTCOUNTRIES_COM_V_3_1 + ALL, String.class);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> getCountryData(@PathVariable String name) {
        try {
            return restTemplate.getForEntity(HTTPS_RESTCOUNTRIES_COM_V_3_1 + NAME + name, String.class);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
