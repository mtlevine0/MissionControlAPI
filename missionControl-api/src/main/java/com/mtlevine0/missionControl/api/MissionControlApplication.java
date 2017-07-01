package com.mtlevine0.missionControl.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MissionControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MissionControlApplication.class, args);
		System.out.println("MissionControl API is Running!");
	}
}
