package com.gamaset.sonicbot.collector.business.statistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.MatchResumeDTO;
import com.gamaset.sonicbot.collector.dto.detail.MatchDetailDTO;
import com.gamaset.sonicbot.collector.dto.statistic.MatchStatisticDTO;
import com.gamaset.sonicbot.collector.infra.CachingConfig;
import com.gamaset.sonicbot.collector.service.academia.matchdetail.MatchDetailAcademiaService;
import com.gamaset.sonicbot.collector.service.statistic.MatchStatisticService;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@Component
public class ManagerProcessMatchStatistic {

	@Autowired
	private MatchDetailAcademiaService matchDetailAcademiaService;
	@Autowired
	private MatchStatisticService statisticService;
	
	/**
	 * 
	 * @param match
	 * @return 
	 */
	@Cacheable(cacheNames = CachingConfig.MATCH_STATS_CHACHE)
	public MatchStatisticDTO generateStatistics(MatchResumeDTO match){
		
		MatchDetailDTO detail = matchDetailAcademiaService.detail(match);
		
		return statisticService.calculate(detail);
	}
	
}
