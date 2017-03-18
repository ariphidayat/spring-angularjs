package org.arip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ResourceApplication {

	@RequestMapping("/hello")
	@CrossOrigin(origins="*", maxAge=3600, allowedHeaders = { "x-auth-token", "x-requested-with" })
	public Message home() {
		return new Message("Hello World from Resource Application");
	}

	public static void main(String[] args) {
		SpringApplication.run(ResourceApplication.class, args);
	}

    @Configuration
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    protected static class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .cors()
                .and()
                    .authorizeRequests().anyRequest().authenticated();
        }

        @Bean
        HeaderHttpSessionStrategy sessionStrategy() {
            return new HeaderHttpSessionStrategy();
        }
    }
}
