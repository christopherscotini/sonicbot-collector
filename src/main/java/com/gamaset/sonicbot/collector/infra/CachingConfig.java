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

	public static final String MATCH_STATS_CHACHE = "generateStatistics";
	public static final String MATCH_DETAIL_CHACHE = "matchesByDateDetail";
	public static final String MATCH_BY_DATE_CHACHE = "matchesByDate";
	private static final String CRON_CONFIG = "0 50 11 * * ?";
	
	@Autowired
	private LoginComponent login;
	
	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager(MATCH_BY_DATE_CHACHE, MATCH_DETAIL_CHACHE);
	}

	@Scheduled(cron = CRON_CONFIG, zone="America/Sao_Paulo")
	@CacheEvict(allEntries = true, value = {MATCH_BY_DATE_CHACHE})
	public void reportCacheEvictMatchByDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		login.resetCookie();
		System.out.println("Flush Cache MATCH_BY_DATE_CHACHE: " + now.format(formatter));
	}

	@Scheduled(cron = CRON_CONFIG, zone="America/Sao_Paulo")
	@CacheEvict(allEntries = true, value = {MATCH_DETAIL_CHACHE})
	public void reportCacheEvictMatchDetailByDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		login.resetCookie();
		System.out.println("Flush Cache MATCH_DETAIL_CHACHE: " + now.format(formatter));
	}
	
	@Scheduled(cron = CRON_CONFIG, zone="America/Sao_Paulo")
	@CacheEvict(allEntries = true, value = {MATCH_STATS_CHACHE})
	public void reportCacheEvictStatsByMatch() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		login.resetCookie();
		System.out.println("Flush Cache MATCH_STATS_CHACHE: " + now.format(formatter));
	}


}
