package com.example.demo.weatherreport.userapi;

import java.time.LocalDateTime;

public record ReportWeatherRequest(Double lat,Double lon, LocalDateTime time, String source) {
}
