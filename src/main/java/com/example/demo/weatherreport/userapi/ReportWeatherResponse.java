package com.example.demo.weatherreport.userapi;

import java.time.LocalDateTime;

public record ReportWeatherResponse(String name, LocalDateTime time, double precipitationRate) {
}
