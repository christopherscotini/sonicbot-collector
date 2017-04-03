package com.gamaset.sonicbot.collector.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.MatchResumeDTO;
import com.gamaset.sonicbot.collector.dto.detail.MatchDetailDTO;
import com.gamaset.sonicbot.collector.dto.statistic.MatchStatisticDTO;
import com.gamaset.sonicbot.collector.service.match.MatchDetailService;
import com.gamaset.sonicbot.collector.service.statistic.MatchStatisticService;

@Component
public class ManagerProcessMatchStatistic {

	@Autowired
	private MatchDetailService matchDetailService;
	@Autowired
	private MatchStatisticService statisticService;
	
	/**
	 * 
	 * @param match
	 * @return 
	 */
	public MatchStatisticDTO generateStatistics(MatchResumeDTO match){
		MatchDetailDTO detail = matchDetailService.detail(match);
		
		MatchStatisticDTO statistics = statisticService.calculate(detail);
		
		return statistics;
	}
	
}
