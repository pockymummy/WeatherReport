package com.example.demo.weatherreport.supplierapi.open_meteo.forecast;

import com.example.demo.weatherreport.supplierapi.open_meteo.forecast.request.ForecastRequest;
import com.example.demo.weatherreport.supplierapi.open_meteo.forecast.response.ForecastResponse;
import com.example.demo.weatherreport.userapi.ReportWeatherRequest;
import com.example.demo.weatherreport.userapi.ReportWeatherResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OpenMeteoMapper {
    public ForecastRequest map(ReportWeatherRequest reportWeatherRequest) {
        String dateText = reportWeatherRequest.time().format(DateTimeFormatter.ISO_LOCAL_DATE);
        return new ForecastRequest(reportWeatherRequest.lat(),reportWeatherRequest.lon(),"precipitation_probability", dateText,dateText);
    }
    public ReportWeatherResponse reverseMap(ForecastResponse forecastResponse) {
        return new ReportWeatherResponse("", LocalDateTime.now(),10);
    }
}
