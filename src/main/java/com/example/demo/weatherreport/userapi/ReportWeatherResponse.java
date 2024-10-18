package com.example.demo.weatherreport.userapi;

import java.sql.Timestamp;

public record ReportWeatherResponse(String name, Timestamp time, double precipitationRate) {
}
