package com.pluralsight.dealership;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The DealershipApplication class represents the entry point for the Dealership application.
 * This class initializes the Spring Boot application context and starts the application.
 */
@SpringBootApplication
public class DealershipApplication {

	/**
	 * The main method is the entry point for the Dealership application.
	 * It initializes the Spring Boot application context and starts the application.
	 *
	 * @param args The command-line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(DealershipApplication.class, args);
	}

}
