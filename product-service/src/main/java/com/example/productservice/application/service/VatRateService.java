package com.example.productservice.application.service;



import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VatRateService {

    private final Map<String, Double> vatRates;

    public VatRateService() {
        vatRates = new HashMap<>();
        vatRates.put("PT", 0.23);      // Example: Portugal VAT
        vatRates.put("ES", 0.21);      // Example: Spain VAT
        vatRates.put("US", 0.07);      // Example: US sales tax
        vatRates.put("UK", 0.20);      // Example: UK VAT
        vatRates.put("JP", 0.10);      // Example: Japan consumption tax
        // Add more regions and their VAT rates as necessary
    }

    public double getVatRate(String region) {
        return vatRates.getOrDefault(region.toUpperCase(), 0.20); // Default to 20% if region not found
    }
}
