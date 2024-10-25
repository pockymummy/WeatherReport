package com.example.demo.weatherreport.supplierapi.weatherapi;

import com.example.demo.weatherreport.supplierapi.weatherapi.forecast.request.WeatherApiForecastRequest;
import com.example.demo.weatherreport.supplierapi.weatherapi.forecast.response.WeatherApiForecastResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClient;

import java.util.Optional;

import static com.example.demo.DemoApplication.log;

public class WeatherApiClient {

    @Autowired
    private RestClient client;

    public WeatherApiForecastResponse forecast(WeatherApiForecastRequest request) {
        WeatherApiForecastResponse response =  client.get()
                .uri("http://api.weatherapi.com/v1/forecast.json?key={key}&q={q}&dt={dt}",request.key(),request.q(),request.dt())
                .retrieve()
                .body(WeatherApiForecastResponse.class);
        log.info("Response serialized: {}", Optional.ofNullable(response));
        return response;
    } ;
}
