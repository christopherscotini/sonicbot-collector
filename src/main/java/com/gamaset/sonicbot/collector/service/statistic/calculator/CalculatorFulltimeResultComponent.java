package com.gamaset.sonicbot.collector.service.statistic.calculator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.detail.TeamMatchDetailDTO;
import com.gamaset.sonicbot.collector.dto.statistic.StatsMarketDTO;
import com.gamaset.sonicbot.collector.infra.constants.HomeAwayConditionEnum;
import com.gamaset.sonicbot.collector.infra.constants.SelectionMarketBetConstants;

@Component
public class CalculatorFulltimeResultComponent {

	@Autowired
	private EffectSizeCalculatorComponent sizeCalculator;

	public StatsMarketDTO calculate(List<TeamMatchDetailDTO> matchesByCondition,
			HomeAwayConditionEnum condition) {
		StatsMarketDTO result = new StatsMarketDTO();

		int occurs = 0;

		for (TeamMatchDetailDTO detail : matchesByCondition) {
			if (HomeAwayConditionEnum.HOME_TEAM.equals(condition)) {
				if (detail.getWinner() != null && detail.getWinner().equals(detail.getHomeTeamMatch())) {
					occurs++;
				}
			} else {
				if (detail.getWinner() != null && detail.getWinner().equals(detail.getAwayTeamMatch())) {
					occurs++;
				}
			}
		}

		try {
			result.setValue(new Double((occurs * 100) / matchesByCondition.size()));
			if(HomeAwayConditionEnum.HOME_TEAM.equals(condition)){
				result.setSize(sizeCalculator.calculateForWin(result.getValue(), HomeAwayConditionEnum.HOME_TEAM));
				result.setSelectionMarketBetId(SelectionMarketBetConstants.HOME_TEAM_WIN.getId());
			}else{
				result.setSize(sizeCalculator.calculateForWin(result.getValue(), HomeAwayConditionEnum.AWAY_TEAM));
				result.setSelectionMarketBetId(SelectionMarketBetConstants.AWAY_TEAM_WIN.getId());
			}
		} catch (ArithmeticException a) {
			
		}

		return result;
	}

}
