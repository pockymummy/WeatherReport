package com.example.demo.weatherreport.supplierapi.weatherapi.forecast.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record Hour(@JsonFormat(pattern="yyyy-MM-dd HH:mm") LocalDateTime time, int chance_of_rain) {
}
