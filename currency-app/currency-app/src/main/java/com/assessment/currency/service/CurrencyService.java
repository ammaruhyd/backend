package com.assessment.currency.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface CurrencyService {
    public JsonNode getExchangeRates(String from);
    public double convert(String from, String to, double amount);
}
