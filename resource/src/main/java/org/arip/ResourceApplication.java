package org.arip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableResourceServer
@SpringBootApplication
public class ResourceApplication {

	@RequestMapping("/hello")
	public Message hello() {
		return new Message("Hello World from Resource Application");
	}

	public static void main(String[] args) {
		SpringApplication.run(ResourceApplication.class, args);
	}
}
