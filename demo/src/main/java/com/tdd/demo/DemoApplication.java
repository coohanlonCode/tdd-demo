package com.tdd.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		EvenOddService service = new EvenOddService();

		boolean isInputOdd = service.isOddNumber(3);
	}

}
