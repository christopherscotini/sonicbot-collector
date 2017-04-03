package com.gamaset.sonicbot.collector.service.statistic.calculator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.detail.TeamMatchDetailDTO;
import com.gamaset.sonicbot.collector.dto.statistic.StatsMarketDTO;
import com.gamaset.sonicbot.collector.infra.constants.HomeAwayConditionEnum;
import com.gamaset.sonicbot.collector.infra.constants.SelectionMarketBetConstants;


@Component
public class CalculatorDoubleChanceComponent {

	@Autowired
	private EffectSizeCalculatorComponent sizeCalculator;

	
	public StatsMarketDTO calculate(List<TeamMatchDetailDTO> matchesByCondition, HomeAwayConditionEnum condition) {
		StatsMarketDTO result = new StatsMarketDTO();
		
		int occurs = 0;

		for (TeamMatchDetailDTO matchResume : matchesByCondition) {
			if(condition.equals(HomeAwayConditionEnum.HOME_TEAM)){
				if (matchResume.getWinner() == null || matchResume.getWinner().equals(matchResume.getHomeTeamMatch())){
					occurs++;
				}
			}else{
				if (matchResume.getWinner() == null || matchResume.getWinner().equals(matchResume.getAwayTeamMatch())){
					occurs++;
				}
			}
		}

		try {
			result.setValue(new Double((occurs * 100) / matchesByCondition.size()));
			if(HomeAwayConditionEnum.HOME_TEAM.equals(condition)){
				result.setSize(sizeCalculator.calculateForDoubleChance(result.getValue(), condition));
				result.setSelectionMarketBetId(SelectionMarketBetConstants.HOME_TEAM_OR_DRAW.getId());
			}else{
				result.setSize(sizeCalculator.calculateForDoubleChance(result.getValue(), condition));
				result.setSelectionMarketBetId(SelectionMarketBetConstants.HOME_TEAM_OR_DRAW.getId());
			}
		} catch (ArithmeticException a) {
		}

		return result;
	}

}
