package com.example.demo.weatherreport.supplierapi.weatherapi;

import com.example.demo.weatherreport.supplierapi.weatherapi.forecast.request.WeatherApiForecastRequest;
import com.example.demo.weatherreport.supplierapi.weatherapi.forecast.response.Forecast;
import com.example.demo.weatherreport.supplierapi.weatherapi.forecast.response.Hour;
import com.example.demo.weatherreport.supplierapi.weatherapi.forecast.response.WeatherApiForecastResponse;
import com.example.demo.weatherreport.userapi.ReportWeatherRequest;
import com.example.demo.weatherreport.userapi.ReportWeatherResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static com.example.demo.DemoApplication.log;

public class WeatherApiMapper {

    public WeatherApiForecastRequest map(ReportWeatherRequest reportWeatherRequest) {
        StringBuilder q = new StringBuilder();
        q.append(reportWeatherRequest.lat());
        q.append(",");
        q.append(reportWeatherRequest.lon());
        return new WeatherApiForecastRequest("8b2035a1b2344516afe11619241810", q.toString(), reportWeatherRequest.time().format(DateTimeFormatter.ISO_LOCAL_DATE));
    }
    public ReportWeatherResponse reverseMap(WeatherApiForecastResponse weatherApiForecastResponse, ReportWeatherRequest reportWeatherRequest) {
        log.info(weatherApiForecastResponse.toString());
        LocalDateTime onlyHourDateTime = reportWeatherRequest.time().withMinute(0).withSecond(0);
        Hour matchedHour = weatherApiForecastResponse.forecast()
                .forecastday().get(0)
                .hour().stream().filter(hour -> hour.time().equals(onlyHourDateTime)).findAny()
                .orElse(new Hour(LocalDateTime.now(),-1));
        return new ReportWeatherResponse("", matchedHour.time(),matchedHour.chance_of_rain());
    }
}
