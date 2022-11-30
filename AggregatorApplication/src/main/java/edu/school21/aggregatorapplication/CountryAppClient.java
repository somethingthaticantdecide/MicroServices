package edu.school21.aggregatorapplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Component
public class CountryAppClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryAppClient.class);

    private final RestTemplate restTemplate;

    CountryAppClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> getAll() {
        LOGGER.debug("Sending request for all countries");
        return restTemplate.getForEntity("http://countries-management/countries-management/countries/all", String.class);
    }

    public ResponseEntity<String> getCountryData(@PathVariable String name) {
        LOGGER.debug("Sending request for country name: {}", name);
        return restTemplate.getForEntity("http://countries-management/countries-management/countries/name/" + name, String.class);
    }
}
