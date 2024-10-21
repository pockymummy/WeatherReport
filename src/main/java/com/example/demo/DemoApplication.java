package com.example.demo;
import com.example.demo.weatherreport.supplierapi.weatherapi.WeatherApiClient;
import com.example.demo.weatherreport.supplierapi.weatherapi.WeatherApiMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@SpringBootApplication
public class DemoApplication {
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		System.out.println(LocalDateTime.now());
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public WeatherApiClient weatherApiClient() {
		return new WeatherApiClient();
	}

	@Bean
	public WeatherApiMapper weatherApiMapper() {
		return new WeatherApiMapper();
	}
}