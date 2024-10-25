package com.example.demo.weatherreport;

import com.example.demo.weatherreport.supplierapi.openMeteo.forecast.request.OpenMeteoForecastRequest;
import com.example.demo.weatherreport.supplierapi.openMeteo.forecast.response.OpenMeteoForecastResponse;
import com.example.demo.weatherreport.supplierapi.openMeteo.forecast.OpenMeteoClient;
import com.example.demo.weatherreport.supplierapi.openMeteo.forecast.OpenMeteoMapper;
import com.example.demo.weatherreport.supplierapi.weatherapi.WeatherApiClient;
import com.example.demo.weatherreport.supplierapi.weatherapi.WeatherApiMapper;
import com.example.demo.weatherreport.supplierapi.weatherapi.forecast.request.WeatherApiForecastRequest;
import com.example.demo.weatherreport.supplierapi.weatherapi.forecast.response.WeatherApiForecastResponse;
import com.example.demo.weatherreport.userapi.ReportWeatherRequest;
import com.example.demo.weatherreport.userapi.ReportWeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            OpenMeteoForecastRequest meteoOpenMeteoForecastRequest = openMeteoMapper.map(request);
            OpenMeteoForecastResponse clientResponse = openMeteoClient.forecast(meteoOpenMeteoForecastRequest);
            return openMeteoMapper.reverseMap(clientResponse);
        }
        else {
            WeatherApiForecastRequest weatherApiForecastRequest = weatherApiMapper.map(request);
            WeatherApiForecastResponse clientResponse = weatherApiClient.forecast(weatherApiForecastRequest);
            return  weatherApiMapper.reverseMap(clientResponse, request);
        }
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
