package com.gamaset.sonicbot.collector.service.statistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamaset.sonicbot.collector.dto.detail.MatchDetailDTO;
import com.gamaset.sonicbot.collector.dto.statistic.MatchStatisticDTO;
import com.gamaset.sonicbot.collector.infra.constants.HomeAwayConditionEnum;
import com.gamaset.sonicbot.collector.service.statistic.calculator.ManagerTeamStatisticsCalculator;

@Service
public class MatchStatisticService {

	@Autowired
	private ManagerTeamStatisticsCalculator managerTeamStatisticsCalculator;
	
	public MatchStatisticDTO calculate(MatchDetailDTO detail) {

		MatchStatisticDTO stats = new MatchStatisticDTO();
		
		stats.setHomeTeamStats(managerTeamStatisticsCalculator.calculate(detail.getMatchDetailHomeTeam(), HomeAwayConditionEnum.HOME_TEAM));
		stats.setAwayTeamStats(managerTeamStatisticsCalculator.calculate(detail.getMatchDetailAwayTeam(), HomeAwayConditionEnum.AWAY_TEAM));
		
		return stats;
	}

}
