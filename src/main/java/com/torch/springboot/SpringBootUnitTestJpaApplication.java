package com.torch.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringBootUnitTestJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUnitTestJpaApplication.class, args);
	}
}
