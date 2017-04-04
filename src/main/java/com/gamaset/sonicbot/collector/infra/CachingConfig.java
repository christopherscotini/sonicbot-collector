package com.gamaset.sonicbot.collector.infra;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.gamaset.sonicbot.collector.service.login.LoginComponent;


/**
 *
 *
 * @author Christopher Rozario
 *
 * @since 0.0.1
 */
@Configuration
@EnableCaching
@EnableScheduling
public class CachingConfig {

	private final String PREDICTIONS = "predictions";
	
	@Autowired
	private LoginComponent login;
	
	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager(PREDICTIONS);
	}

	//fixedDelay = 3 minutos
	@Scheduled(fixedDelay = 400 * 60 * 1000, initialDelay = 500)
	@CacheEvict(allEntries = true, value = {PREDICTIONS})
	public void reportCacheEvict() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		login.resetCookie();
		System.out.println("Flush Cache " + now.format(formatter));
	}

}
