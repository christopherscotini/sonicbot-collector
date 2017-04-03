package com.gamaset.sonicbot.collector.service.statistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.detail.MatchDetailTeamDTO;
import com.gamaset.sonicbot.collector.dto.statistic.TeamStatisticsDTO;
import com.gamaset.sonicbot.collector.infra.constants.HomeAwayConditionEnum;
import com.gamaset.sonicbot.collector.service.statistic.calculator.CalculatorDoubleChanceComponent;
import com.gamaset.sonicbot.collector.service.statistic.calculator.CalculatorFulltimeResultComponent;

@Component
public class TeamStatisticsComponent {

	@Autowired
	private CalculatorFulltimeResultComponent calculatorFulltimeResult;
	@Autowired
	private CalculatorDoubleChanceComponent calculatorDoubleChance;

	public TeamStatisticsDTO calculate(MatchDetailTeamDTO matchDetailTeam, HomeAwayConditionEnum condition) {
		
		TeamStatisticsDTO statsDTO = new TeamStatisticsDTO();
		statsDTO.setFulltimeResult(calculatorFulltimeResult.calculate(matchDetailTeam.getMatchesByCondition(), condition));
		statsDTO.setDoubleChanceResult(calculatorDoubleChance.calculate(matchDetailTeam.getMatchesByCondition(), condition));
		
		return statsDTO;
	}
	
}
