package com.example.demo.weatherreport.supplierapi.weatherapi;

import com.example.demo.weatherreport.supplierapi.weatherapi.forecast.request.ForecastRequest;
import com.example.demo.weatherreport.supplierapi.weatherapi.forecast.response.ForecastResponse;
import org.springframework.web.client.RestClient;

public class WeatherApiClient {

    public ForecastResponse forecast(ForecastRequest request) {
        RestClient client = RestClient.create();
        return client.get()
                .uri("http://api.weatherapi.com/v1/forecast.json?key={key}&q={q}",request.key(),request.q())
                .retrieve()
                .body(ForecastResponse.class);
    } ;
}
