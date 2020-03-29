package com.hrishi.healthscience.covid19tracker20;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Covid19Tracker20Application {

	public static void main(String[] args) {
		SpringApplication.run(Covid19Tracker20Application.class, args);
	}

}
