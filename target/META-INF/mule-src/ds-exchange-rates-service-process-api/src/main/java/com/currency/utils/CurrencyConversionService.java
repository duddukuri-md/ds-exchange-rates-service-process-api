package com.currency.utils;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConversionService {

	private Map<String, Double> exchangeRates;

	public CurrencyConversionService() {
		exchangeRates = new HashMap<>();

		exchangeRates.put("USD", 1.0);
		exchangeRates.put("EUR", 2.0);// Defining a Base currency
	}
	
	// Inserting the exchange rates
	public Map<String, Object> setExchangeRates(Map<String, Double> rates) {
	    Map<String, Object> response = new HashMap<>();
	    
	    if (rates != null) {
	        for (Map.Entry<String, Double> entry : rates.entrySet()) {
	            exchangeRates.put(entry.getKey(), entry.getValue());
	        }
	        response.put("success", true);
	        response.put("message", "Exchange rates have been updated.");
	    } else {
	        response.put("success", false);
	        response.put("message", "No exchange rates provided.");
	    }
	    
	    return response;
	}

	
	// Validating if we have any Exchange rates
	    public boolean areExchangeRatesAvailable() {
        // Check if exchange rates are available in memory
    	System.out.println("Checking exchange rates availability");
        return !exchangeRates.isEmpty();
    }

	//Exchange Rate calculation 
	public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
		if (exchangeRates.containsKey(fromCurrency) && exchangeRates.containsKey(toCurrency)) {
			double exchangeRate = exchangeRates.get(toCurrency) / exchangeRates.get(fromCurrency);
			double convertedAmount = amount * exchangeRate;
			System.out.println("Converting " + amount + " " + fromCurrency + " to " + toCurrency);
			System.out.println("Exchange Rate: " + exchangeRate);
			System.out.println("Converted Amount: " + convertedAmount);
			return convertedAmount;
		} 
		else 
		{
			String errorMessage = "Failed to convert currency. Exchange rates for " + fromCurrency + " to " + toCurrency
					+ " not available.";
			System.err.println(errorMessage);
			return -1;
		}
	}
	
	//Clear Exchange Rates
	public String clearExchangeRates() {
		exchangeRates.clear();
		System.out.println("Clearing exchange rates");
		return "Exchange rates have been cleared.";
	}
}
