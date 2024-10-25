package com.example.demo.weatherreport.supplierapi.openMeteo.forecast.request;

public record OpenMeteoForecastRequest(Double latitude, Double longitude, String hourly, String start_date, String end_date) {
}
