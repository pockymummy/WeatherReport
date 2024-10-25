package com.example.demo.weatherreport.supplierapi.openMeteo.forecast;

import com.example.demo.weatherreport.supplierapi.openMeteo.forecast.request.OpenMeteoForecastRequest;
import com.example.demo.weatherreport.supplierapi.openMeteo.forecast.response.OpenMeteoForecastResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClient;

import static com.example.demo.DemoApplication.log;

public class OpenMeteoClient {

    @Autowired
    private RestClient client;

    public OpenMeteoForecastResponse forecast(OpenMeteoForecastRequest request) {
        OpenMeteoForecastResponse response =  client.get()
                .uri("https://api.open-meteo.com/v1/forecast?latitude={lat}&longitude={lon}&hourly={hourly}&start_date={start_date}&end_date={end_date}",request.latitude(),request.longitude(),request.hourly(),request.start_date(),request.end_date())
                .retrieve()
                .body(OpenMeteoForecastResponse.class);
        log.info("Response serialized: {}", response.toString());
        return response;
    } ;
}
