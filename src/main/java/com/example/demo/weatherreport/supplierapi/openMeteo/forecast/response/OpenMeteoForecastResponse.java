package com.example.demo.weatherreport.supplierapi.openMeteo.forecast.response;

public record OpenMeteoForecastResponse(Double latitude, Double longitude, Hourly hourly) {
}
