package com.assessment.currency.service.impl;

import com.assessment.currency.service.CurrencyService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private static final String API_KEY = "3425df84ab5ec09a034b0db9";
    private static final String API_URL = "https://open.er-api.com/v6/latest/";

    @Autowired
    private RestTemplate restTemplate;

    @Cacheable(value = "exchangeRates", key = "#from")
    public JsonNode getExchangeRates(String from) {
        String url = API_URL + from + "?apikey=" + API_KEY;
        ResponseEntity<JsonNode> response = restTemplate.getForEntity(url, JsonNode.class);
        return response.getBody().get("rates");
    }

    public double convert(String from, String to, double amount) {
        JsonNode rates = getExchangeRates(from);
        double rate = rates.get(to).asDouble();
        return amount * rate;
    }
}
