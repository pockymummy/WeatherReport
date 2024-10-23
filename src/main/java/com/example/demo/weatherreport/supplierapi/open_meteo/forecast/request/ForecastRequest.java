package com.example.demo.weatherreport.supplierapi.open_meteo.forecast.request;

public record ForecastRequest(Double latitude, Double longitude, String hourly, String start_date, String end_date) {
}
