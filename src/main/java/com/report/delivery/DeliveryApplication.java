package com.report.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class DeliveryApplication {

	public static void main(final String[] args) {
		SpringApplication.run(DeliveryApplication.class, args);
	}

}
