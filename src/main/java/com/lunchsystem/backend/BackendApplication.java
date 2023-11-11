package com.lunchsystem.backend;

import com.lunchsystem.backend.services.CheckOrderLifeTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		Thread thread = new Thread(new CheckOrderLifeTime());
		thread.start();
	}

}
