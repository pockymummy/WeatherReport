package com.example.demo.weatherreport.supplierapi.weatherapi.forecast.response;

import java.util.List;

public record ForecastDay(List<Hour> hour) {
}
