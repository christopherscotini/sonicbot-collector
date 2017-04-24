package com.gamaset.sonicbot.collector.infra;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;


/**
 *
 *
 * @author Christopher Rozario
 *
 * @since 0.0.1
 */
public class CachingConfig {

	private static final Logger LOG = LogManager.getLogger(CachingConfig.class);

	public static final String MATCH_STATS_CHACHE = "generateStatistics";
	public static final String MATCH_DETAIL_CHACHE = "matchesByDateDetail";
	public static final String MATCH_BY_DATE_CHACHE = "matchesByDate";
	private static final String CRON_CONFIG = "0 50 11 * * ?";
	
	@Bean
	public CacheManager cacheManager() {
		LOG.info("== creating cacheManager: ".concat(MATCH_STATS_CHACHE).concat(";").concat(MATCH_BY_DATE_CHACHE).concat(";").concat(MATCH_DETAIL_CHACHE));
		return new ConcurrentMapCacheManager(MATCH_BY_DATE_CHACHE, MATCH_DETAIL_CHACHE, MATCH_STATS_CHACHE);
	}

}
