package com.gamaset.sonicbot.collector.service.statistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamaset.sonicbot.collector.dto.detail.MatchDetailDTO;
import com.gamaset.sonicbot.collector.dto.statistic.MatchStatisticDTO;
import com.gamaset.sonicbot.collector.infra.constants.HomeAwayConditionEnum;

@Service
public class MatchStatisticService {

	@Autowired
	private TeamStatisticsComponent teamStatsCalculator;
	
	public MatchStatisticDTO calculate(MatchDetailDTO detail) {

		MatchStatisticDTO stats = new MatchStatisticDTO();
		stats.setHomeTeamStats(teamStatsCalculator.calculate(detail.getMatchDetailHomeTeam(), HomeAwayConditionEnum.HOME_TEAM));
		stats.setAwayTeamStats(teamStatsCalculator.calculate(detail.getMatchDetailAwayTeam(), HomeAwayConditionEnum.AWAY_TEAM));
		
		return stats;
	}

}
