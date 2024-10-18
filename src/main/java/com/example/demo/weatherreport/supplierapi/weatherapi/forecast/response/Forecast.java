package com.example.demo.weatherreport.supplierapi.weatherapi.forecast.response;

import java.util.List;

record Forecast(List<ForecastDay> forecastDays) {
}
