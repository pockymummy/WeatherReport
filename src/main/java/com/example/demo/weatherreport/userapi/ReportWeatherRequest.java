package com.example.demo.weatherreport.userapi;

import java.time.LocalDateTime;

public record ReportWeatherRequest(String name, LocalDateTime time) {
}
