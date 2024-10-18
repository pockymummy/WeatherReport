package com.example.demo;

import java.sql.Timestamp;

public record ReportWeatherResponse(String name, Timestamp time, double precipitationRate) {
}
