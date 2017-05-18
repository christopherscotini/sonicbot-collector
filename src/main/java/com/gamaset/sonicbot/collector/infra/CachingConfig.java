package com.gamaset.sonicbot.collector.infra;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.infra.utils.DateUtils;


/**
 *
 *
 * @author Christopher Rozario
 *
 * @since 0.0.1
 */
@Component
public class CachingConfig {

	private static final Logger LOG = LogManager.getLogger(CachingConfig.class);

	public static final String MATCH_STATS_CHACHE = "generateStatistics";
	public static final String MATCH_DETAIL_CHACHE = "matchesByDateDetail";
	public static final String MATCH_BY_DATE_CHACHE = "matchesByDate";
	public static final String TEAM_COMP_SEAS = "teamCompSeason";
	public static final String SELECT_MARKET_BET_CACHE = "selectionMarketBetCache";
	public static final String COMP_SEASON_CACHE = "competitionSeasonCache";
	public static final String TEAM_COMP_SEAS_BY_COMP = "teamCompSeasonByCompetition";
	
	
	private static final String CRON_CONFIG = "0 50 11 * * ?";
	
	@Bean
	public CacheManager cacheManager() {
		
		LOG.info("== creating cacheManager: ".
				concat(MATCH_STATS_CHACHE).concat(";").
				concat(MATCH_DETAIL_CHACHE).
				concat(MATCH_BY_DATE_CHACHE).concat(";").
				concat(TEAM_COMP_SEAS).concat(";").
				concat(SELECT_MARKET_BET_CACHE).concat(";").
				concat(COMP_SEASON_CACHE).concat(";").
				concat(TEAM_COMP_SEAS_BY_COMP).concat(";")
				);
		
		return new ConcurrentMapCacheManager(
				MATCH_STATS_CHACHE, 
				MATCH_DETAIL_CHACHE, 
				MATCH_BY_DATE_CHACHE, 
				TEAM_COMP_SEAS,
				SELECT_MARKET_BET_CACHE,
				COMP_SEASON_CACHE,
				TEAM_COMP_SEAS_BY_COMP
				);
	}
	
	@CacheEvict(allEntries = true, value = {SELECT_MARKET_BET_CACHE})
    public void resetCacheSelectionMarketbet() {
		LOG.info("Flush Cache [SELECT_MARKET_BET_CACHE] at " + DateUtils.getNowDateTimeFormatted());
    }

	@CacheEvict(allEntries = true, value = {TEAM_COMP_SEAS})
	public void resetCacheTeamCompSeason() {
		LOG.info("Flush Cache [TEAM_COMP_SEAS] at " + DateUtils.getNowDateTimeFormatted());
	}

	@CacheEvict(allEntries = true, value = {COMP_SEASON_CACHE})
	public void resetCacheCompSeason() {
		LOG.info("Flush Cache [COMP_SEASON_CACHE] at " + DateUtils.getNowDateTimeFormatted());
	}

	@CacheEvict(allEntries = true, value = {TEAM_COMP_SEAS_BY_COMP})
	public void resetCacheTeamCompSeasonByCompetition() {
		LOG.info("Flush Cache [TEAM_COMP_SEAS_BY_COMP] at " + DateUtils.getNowDateTimeFormatted());
	}

}
