package com.gamaset.sonicbot.collector.service.statistic.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.detail.MatchDetailTeamDTO;
import com.gamaset.sonicbot.collector.dto.statistic.TeamStatisticsDTO;
import com.gamaset.sonicbot.collector.infra.constants.HomeAwayConditionEnum;

/**
 * Componente responsavel por gerenciar as coletas de calculo de probabilidades
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@Component
public class ManagerTeamStatisticsCalculator {

	@Autowired
	private CalculatorFulltimeResultComponent calculatorFulltimeResult;
	@Autowired
	private CalculatorDoubleChanceComponent calculatorDoubleChance;
	@Autowired
	private CalculatorGoalsComponent calculatoGoals;

	/**
	 * Metodo responsavel por fazer a coleta de dados POR TIME e Condição(Home or Away)
	 * 
	 * @param matchDetailTeam
	 * @param condition
	 * @return return a {@link TeamStatisticsDTO} object
	 */
	public TeamStatisticsDTO calculate(MatchDetailTeamDTO matchDetailTeam, HomeAwayConditionEnum condition) {
		
		TeamStatisticsDTO statsDTO = new TeamStatisticsDTO();
		statsDTO.setFulltimeProbabilities(calculatorFulltimeResult.calculate(matchDetailTeam.getMatchesByCondition(), condition));
		statsDTO.setDoubleChanceProbabilities(calculatorDoubleChance.calculate(matchDetailTeam.getMatchesByCondition(), condition));
		statsDTO.setGoalsProbabilities(calculatoGoals.calculate(matchDetailTeam.getMatchesByCondition(), condition));
		statsDTO.setPositions(matchDetailTeam.getPositions());
		
		return statsDTO;
	}
	
}
