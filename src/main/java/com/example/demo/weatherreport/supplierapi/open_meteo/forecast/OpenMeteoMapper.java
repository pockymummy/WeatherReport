package com.example.demo.weatherreport.supplierapi.weatherapi;

import com.example.demo.weatherreport.supplierapi.weatherapi.forecast.request.ForecastRequest;
import com.example.demo.weatherreport.supplierapi.weatherapi.forecast.response.ForecastResponse;
import com.example.demo.weatherreport.userapi.ReportWeatherRequest;
import com.example.demo.weatherreport.userapi.ReportWeatherResponse;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static com.example.demo.DemoApplication.log;

public class WeatherApiMapper {
    public ForecastRequest map(ReportWeatherRequest reportWeatherRequest) {
        StringBuilder q = new StringBuilder();
        q.append(reportWeatherRequest.lat());
        q.append(",");
        q.append(reportWeatherRequest.lon());
        log.info(q.toString());
        return new ForecastRequest("8b2035a1b2344516afe11619241810", q.toString());
    }
    public ReportWeatherResponse reverseMap(ForecastResponse forecastResponse) {
        return new ReportWeatherResponse("", LocalDateTime.now(),10);
    }
}
