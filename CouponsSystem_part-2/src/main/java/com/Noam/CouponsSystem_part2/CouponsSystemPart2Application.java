package com.Noam.CouponsSystem_part2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CouponsSystemPart2Application {

	public static void main(String[] args) {
		SpringApplication.run(CouponsSystemPart2Application.class, args);
		System.out.println("Server is running..");
	}

}
