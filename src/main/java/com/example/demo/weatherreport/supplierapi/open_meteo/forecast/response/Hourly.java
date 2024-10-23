package com.example.demo.weatherreport.supplierapi.open_meteo.forecast.response;

import java.util.List;

public record Hourly(List<String> time, List<Integer> precipitation_probability) {
}
