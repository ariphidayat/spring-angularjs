package org.arip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@SpringBootApplication
public class SpringAngularjsApplication {

    @RequestMapping(value = "hello")
	public Map<String, Object> hello() {
		Map<String, Object> model = new HashMap<>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello Spring Boot and AngularJS!");
		return model;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringAngularjsApplication.class, args);
	}
}
