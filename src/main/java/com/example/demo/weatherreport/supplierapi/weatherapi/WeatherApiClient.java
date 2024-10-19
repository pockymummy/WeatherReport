package com.example.demo.weatherreport.supplierapi.weatherapi;

import com.example.demo.weatherreport.supplierapi.weatherapi.forecast.request.ForecastRequest;
import com.example.demo.weatherreport.supplierapi.weatherapi.forecast.response.ForecastResponse;
import org.springframework.web.client.RestClient;

public class WeatherApiClient {

    public ForecastResponse forecast(ForecastRequest request) {
        RestClient client = RestClient.create();
        return client.post()
                .uri("http://api.weatherapi.com/v1/forecast.json")
                .body(request)
                .retrieve()
                .body(ForecastResponse.class);
    } ;
}
