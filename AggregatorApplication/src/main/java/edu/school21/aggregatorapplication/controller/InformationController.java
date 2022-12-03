package edu.school21.aggregatorapplication.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.school21.aggregatorapplication.CountryAppClient;
import edu.school21.aggregatorapplication.CovidAppClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InformationController {
    private final CovidAppClient covidAppClient;
    private final CountryAppClient countryAppClient;

    public InformationController(CovidAppClient covidAppClient, CountryAppClient countryAppClient) {
        this.covidAppClient = covidAppClient;
        this.countryAppClient = countryAppClient;
    }

    @GetMapping("/information-management/countries/{name}")
    public ResponseEntity<String> getCountryData(@PathVariable String name) throws JsonProcessingException {
        String covid = covidAppClient.getCountryData(name).getBody();
        String country = countryAppClient.getCountryData(name).getBody();
        JsonNode complexNode = new ObjectMapper().readTree(String.format("{\"covid-info\": %s, \"country-info\": %s}", covid, country));
        return ResponseEntity.ok(complexNode.toPrettyString());

//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode covidNode = mapper.readTree(covidAppClient.getCountryData(name).getBody());
//        JsonNode countryNode =  mapper.readTree(countryAppClient.getCountryData(name).getBody()).get(0);
//        return ResponseEntity.ok(new Information(covidNode, countryNode));
    }
}
