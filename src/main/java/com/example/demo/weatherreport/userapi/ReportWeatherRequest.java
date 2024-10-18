package com.example.demo.weatherreport.userapi;

import java.sql.Timestamp;

public record ReportWeatherRequest(String name, Timestamp time) {
}
