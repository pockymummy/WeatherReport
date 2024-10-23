package com.example.demo.weatherreport;

import com.example.demo.weatherreport.supplierapi.open_meteo.forecast.OpenMeteoClient;
import com.example.demo.weatherreport.supplierapi.open_meteo.forecast.OpenMeteoMapper;
import com.example.demo.weatherreport.supplierapi.weatherapi.WeatherApiClient;
import com.example.demo.weatherreport.supplierapi.weatherapi.WeatherApiMapper;
import com.example.demo.weatherreport.supplierapi.weatherapi.forecast.request.ForecastRequest;
import com.example.demo.weatherreport.supplierapi.weatherapi.forecast.response.ForecastResponse;
import com.example.demo.weatherreport.userapi.ReportWeatherRequest;
import com.example.demo.weatherreport.userapi.ReportWeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static com.example.demo.DemoApplication.log;

@RestController
public class WeatherReportController {

    @Autowired
    private WeatherApiClient weatherApiClient;
    @Autowired
    private WeatherApiMapper weatherApiMapper;
    @Autowired
    private OpenMeteoClient openMeteoClient;
    @Autowired
    private OpenMeteoMapper openMeteoMapper;
    @GetMapping("/reportWeather")
    public ReportWeatherResponse reportWeather(ReportWeatherRequest request) {
        if (request.source().equals("openMeteo")) {
            com.example.demo.weatherreport.supplierapi.open_meteo.forecast.request.ForecastRequest meteoForecastRequest = openMeteoMapper.map(request);
            com.example.demo.weatherreport.supplierapi.open_meteo.forecast.response.ForecastResponse clientResponse = openMeteoClient.forecast(meteoForecastRequest);
            return openMeteoMapper.reverseMap(clientResponse);
        }
        else {
            ForecastRequest forecastRequest = weatherApiMapper.map(request);
            ForecastResponse clientResponse = weatherApiClient.forecast(forecastRequest);
            return  weatherApiMapper.reverseMap(clientResponse);
        }
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
