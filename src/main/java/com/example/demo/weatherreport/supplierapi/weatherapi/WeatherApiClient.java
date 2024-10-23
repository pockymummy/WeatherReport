package com.example.demo.weatherreport.supplierapi.weatherapi;

import com.example.demo.weatherreport.supplierapi.ClientLoggingInterceptor;
import com.example.demo.weatherreport.supplierapi.weatherapi.forecast.request.ForecastRequest;
import com.example.demo.weatherreport.supplierapi.weatherapi.forecast.response.ForecastResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClient;

import java.util.Optional;

import static com.example.demo.DemoApplication.log;

public class WeatherApiClient {

    @Autowired
    private RestClient client;

    public ForecastResponse forecast(ForecastRequest request) {
        ForecastResponse response =  client.get()
                .uri("http://api.weatherapi.com/v1/forecast.json?key={key}&q={q}",request.key(),request.q())
                .retrieve()
                .body(ForecastResponse.class);
        log.info("Response serialized: {}", Optional.ofNullable(response));
        return response;
    } ;
}
