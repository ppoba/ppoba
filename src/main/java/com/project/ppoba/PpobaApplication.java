package com.project.ppoba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class PpobaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PpobaApplication.class, args);
	}

}
