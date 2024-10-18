package com.example.demo.weatherreport;

import com.example.demo.weatherreport.userapi.ReportWeatherRequest;
import com.example.demo.weatherreport.userapi.ReportWeatherResponse;
import org.springframework.web.bind.annotation.*;
import java.util.Random;

@RestController
public class WeatherReportController {
    @GetMapping("/reportWeather")
    public ReportWeatherResponse reportWeather(@RequestBody ReportWeatherRequest request) {
        Random random = new Random();
        return new ReportWeatherResponse(request.name(), request.time(), random.nextDouble());
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
