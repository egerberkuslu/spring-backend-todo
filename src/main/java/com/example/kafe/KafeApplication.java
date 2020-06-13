package com.example.kafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@CrossOrigin
public class KafeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafeApplication.class, args);
	}

}
