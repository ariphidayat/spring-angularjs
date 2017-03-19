package org.arip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.TraceProperties;
import org.springframework.boot.actuate.trace.TraceRepository;
import org.springframework.boot.actuate.trace.WebRequestTraceFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ResourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceApplication.class, args);
	}

    @Bean
    public WebRequestTraceFilter webRequestLoggingFilter(ErrorAttributes err, TraceRepository repo, TraceProperties prop) {
        WebRequestTraceFilter filter = new WebRequestTraceFilter(repo, prop);
        if (err != null) {
            filter.setErrorAttributes(err);
        }
        filter.setOrder(SecurityProperties.DEFAULT_FILTER_ORDER - 1);
        return filter;
    }
}
