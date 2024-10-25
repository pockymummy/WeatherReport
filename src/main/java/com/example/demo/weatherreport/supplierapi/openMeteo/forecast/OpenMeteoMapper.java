package com.example.demo.weatherreport.supplierapi.openMeteo.forecast;

import com.example.demo.weatherreport.supplierapi.openMeteo.forecast.request.OpenMeteoForecastRequest;
import com.example.demo.weatherreport.supplierapi.openMeteo.forecast.response.OpenMeteoForecastResponse;
import com.example.demo.weatherreport.userapi.ReportWeatherRequest;
import com.example.demo.weatherreport.userapi.ReportWeatherResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OpenMeteoMapper {
    public OpenMeteoForecastRequest map(ReportWeatherRequest reportWeatherRequest) {
        String dateText = reportWeatherRequest.time().format(DateTimeFormatter.ISO_LOCAL_DATE);
        return new OpenMeteoForecastRequest(reportWeatherRequest.lat(),reportWeatherRequest.lon(),"precipitation_probability", dateText,dateText);
    }
    public ReportWeatherResponse reverseMap(OpenMeteoForecastResponse openMeteoForecastResponse) {
        return new ReportWeatherResponse("", LocalDateTime.now(),10);
    }
}
