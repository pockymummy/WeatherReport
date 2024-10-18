package com.example.demo;

import java.sql.Timestamp;

public record ReportWeatherRequest(String name, Timestamp time) {
}
