package com.gamaset.sonicbot.collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class SbCollector {
	
	@Autowired
	private SimpleCORSFilter simpleCORSFilter;
	
	@Bean
	public FilterRegistrationBean filterRegistration() {

	    FilterRegistrationBean registration = new FilterRegistrationBean();
	    registration.setFilter(simpleCORSFilter);
	    registration.addUrlPatterns("/*");
	    registration.setName("simpleCORSFilter");
	    
	    return registration;
	}
	
	public static void main(String[] args) {
        SpringApplication.run(SbCollector.class, args);
    }
}
