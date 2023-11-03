# ds-exchange-rates-service-process-api

****Use Case: Currency Exchange via MuleSoft Service****

**Overview**

This project demonstrates the implementation of a currency exchange service using MuleSoft. The use case involves exchanging currency values between different currencies based on the provided exchange rates.

**Use Case Description**
In this use case, we have implemented a currency exchange service that allows users to:
    
    1.Set and update exchange rates for various currencies.
    2.Check if exchange rates are available.
    3.Convert a given amount from one currency to another based on the provided exchange rates.
    4.The project consists of a MuleSoft API that interacts with a Java class called CurrencyConversionService to perform these operations.

**Implementation Details**

This currency exchange service is implemented with the following components:

  1. **Scheduled Maintenance:** A MuleSoft scheduler logic runs daily at 5 AM (New York time) to clear stale exchange rates. 
  
  2. **API Endpoints:** Three MuleSoft API endpoints are exposed to facilitate currency exchange operations:

    1. Set Exchange Rates: This endpoint allows you to insert or update exchange rates. The service leverages the CurrencyConversionService Java class via MuleSoft's invoke method to handle this functionality.
  
    2. Check Exchange Rates Availability: This endpoint verifies if exchange rates are available in memory, providing information on the available currencies and their conversion rates.
    
    3. Convert Currency: You can use this endpoint to perform currency conversion by specifying the source currency, target currency, and the amount to be converted.
