package com.gamaset.sonicbot.collector.service.statistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.detail.MatchDetailTeamDTO;
import com.gamaset.sonicbot.collector.dto.statistic.TeamStatisticsDTO;
import com.gamaset.sonicbot.collector.infra.constants.HomeAwayConditionEnum;
import com.gamaset.sonicbot.collector.service.statistic.calculator.CalculatorDoubleChanceComponent;
import com.gamaset.sonicbot.collector.service.statistic.calculator.CalculatorFulltimeResultComponent;

/**
 * Componente responsavel por gerenciar as coletas de calculo de probabilidades
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@Component
public class TeamStatisticsComponent {

	@Autowired
	private CalculatorFulltimeResultComponent calculatorFulltimeResult;
	@Autowired
	private CalculatorDoubleChanceComponent calculatorDoubleChance;
	@Autowired
	private CalculatorGoalsComponent calculatoGoals;

	public TeamStatisticsDTO calculate(MatchDetailTeamDTO matchDetailTeam, HomeAwayConditionEnum condition) {
		
		TeamStatisticsDTO statsDTO = new TeamStatisticsDTO();
		statsDTO.setFulltimeProbability(calculatorFulltimeResult.calculate(matchDetailTeam.getMatchesByCondition(), condition));
		statsDTO.setDoubleChanceProbability(calculatorDoubleChance.calculate(matchDetailTeam.getMatchesByCondition(), condition));
		statsDTO.setGoalsProbability(calculatoGoals.calculate(matchDetailTeam.getMatchesByCondition(), condition));
		
		return statsDTO;
	}
	
}
