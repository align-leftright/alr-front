package org.weaver.alr.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "org.weaver.alr.front" })
public class ALRFrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(ALRFrontApplication.class, args);
	}
}
