package edu.school21.aggregatorapplication.entity;

import com.fasterxml.jackson.databind.JsonNode;

public class Information {
    public String name;
    public long cases;
    public long todayCases;
    public long deaths;
    public long todayDeaths;
    public long recovered;
    public long active;
    public long critical;
    public long casesPerOneMillion;
    public long deathsPerOneMillion;
    public long totalTests;
    public long testsPerOneMillion;
    public String cca2;
    public String ccn3;
    public String cca3;
    public boolean independent;
    public String status;
    public boolean unMember;
    public String capital;
    public String region;
    public String subregion;
    public boolean landlocked;
    public long area;
    public String flag;
    public long population;
    public String fifa;
    public String startOfWeek;

    public Information(JsonNode covidNode, JsonNode countryNode) {
        this.name = covidNode.get("country").textValue();
        this.cases = covidNode.get("cases").longValue();
        this.todayCases = covidNode.get("todayCases").longValue();
        this.deaths = covidNode.get("deaths").longValue();
        this.todayDeaths = covidNode.get("todayDeaths").longValue();
        this.recovered = covidNode.get("recovered").longValue();
        this.active = covidNode.get("active").longValue();
        this.critical = covidNode.get("critical").longValue();
        this.casesPerOneMillion = covidNode.get("casesPerOneMillion").longValue();
        this.deathsPerOneMillion = covidNode.get("deathsPerOneMillion").longValue();
        this.totalTests = covidNode.get("totalTests").longValue();
        this.testsPerOneMillion = covidNode.get("testsPerOneMillion").longValue();

        this.cca2 = countryNode.get("cca2").textValue();
        this.ccn3 = countryNode.get("ccn3").textValue();
        this.cca3 = countryNode.get("cca3").textValue();
        this.independent = countryNode.get("independent").booleanValue();
        this.status = countryNode.get("status").textValue();
        this.unMember = countryNode.get("unMember").booleanValue();
        this.capital = countryNode.get("capital").get(0).textValue();
        this.region = countryNode.get("region").textValue();
        this.subregion = countryNode.get("subregion").textValue();
        this.landlocked = countryNode.get("landlocked").booleanValue();
        this.area = countryNode.get("area").longValue();
        this.flag = countryNode.get("flag").textValue();
        this.population = countryNode.get("population").longValue();
        this.fifa = countryNode.get("fifa").textValue();
        this.startOfWeek = countryNode.get("startOfWeek").textValue();
    }
}