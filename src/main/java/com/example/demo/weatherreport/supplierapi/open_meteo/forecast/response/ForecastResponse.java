package com.example.demo.weatherreport.supplierapi.open_meteo.forecast.response;

import java.util.List;

public record ForecastResponse(Double latitude, Double longitude, Hourly hourly) {
}
