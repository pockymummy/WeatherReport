package com.example.demo.weatherreport;

import com.example.demo.weatherreport.supplierapi.weatherapi.WeatherApiClient;
import com.example.demo.weatherreport.supplierapi.weatherapi.WeatherApiMapper;
import com.example.demo.weatherreport.supplierapi.weatherapi.forecast.request.ForecastRequest;
import com.example.demo.weatherreport.userapi.ReportWeatherRequest;
import com.example.demo.weatherreport.userapi.ReportWeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class WeatherReportController {

    @Autowired
    private WeatherApiClient weatherApiClient;
    @Autowired
    private WeatherApiMapper weatherApiMapper;
    @GetMapping("/reportWeather")
    public ReportWeatherResponse reportWeather(@RequestBody ReportWeatherRequest request) {
        Random random = new Random();

        ForecastRequest forecastRequest = weatherApiMapper.map(request);
        return  weatherApiMapper.reverseMap(weatherApiClient.forecast(forecastRequest));
//        return new ReportWeatherResponse(request.name(), request.time(), random.nextDouble());
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
