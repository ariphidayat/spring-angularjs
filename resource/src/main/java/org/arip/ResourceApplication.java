package org.arip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ResourceApplication {

	@RequestMapping("/hello")
	@CrossOrigin(origins="*", maxAge=3600)
	public Message home() {
		return new Message("Hello World from Resource Application");
	}

	public static void main(String[] args) {
		SpringApplication.run(ResourceApplication.class, args);
	}
}
