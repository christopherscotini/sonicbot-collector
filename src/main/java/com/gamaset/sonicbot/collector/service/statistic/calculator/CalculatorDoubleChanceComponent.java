package com.gamaset.sonicbot.collector.service.statistic.calculator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.detail.TeamMatchDetailDTO;
import com.gamaset.sonicbot.collector.dto.statistic.probability.DoubleChanceProbabilityDTO;
import com.gamaset.sonicbot.collector.dto.statistic.probability.StatsMarketDTO;
import com.gamaset.sonicbot.collector.infra.constants.CriteriaNumberMatchesType;
import com.gamaset.sonicbot.collector.infra.constants.HomeAwayConditionEnum;
import com.gamaset.sonicbot.collector.infra.constants.SelectionMarketBetType;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@Component
public class CalculatorDoubleChanceComponent {

	@Autowired
	private EffectSizeCalculatorComponent sizeCalculator;

	
	public List<DoubleChanceProbabilityDTO> calculate(List<TeamMatchDetailDTO> matchesByCondition, HomeAwayConditionEnum condition) {
		List<DoubleChanceProbabilityDTO> probs = new ArrayList<>();
		DoubleChanceProbabilityDTO dc = null;
		probs.add(dc = new DoubleChanceProbabilityDTO(CriteriaNumberMatchesType.ALL_GAMES));
		calcProbs(matchesByCondition, condition, dc);
		probs.add(dc = new DoubleChanceProbabilityDTO(CriteriaNumberMatchesType.LAST3_MATCHES));
		calcProbs(matchesByCondition, condition, dc);
		
		return probs;
	}


	private void calcProbs(List<TeamMatchDetailDTO> matches, HomeAwayConditionEnum condition,
			DoubleChanceProbabilityDTO dc) {
		StatsMarketDTO result = new StatsMarketDTO();
		
		int occurs = 0;

		int numberMatches = dc.getNumberMatchesType()==CriteriaNumberMatchesType.ALL_GAMES?matches.size():dc.getNumberMatchesType().getNumerOfMatches();
		for (int i = 0; i < numberMatches; i++) {
			TeamMatchDetailDTO matchResume = matches.get(i);
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
			result.setValue(new Double((occurs * 100) / matches.size()));
			if(HomeAwayConditionEnum.HOME_TEAM.equals(condition)){
				result.setSize(sizeCalculator.calculateForDoubleChance(result.getValue(), condition));
				result.setSelectionMarketBetId(SelectionMarketBetType.HOME_TEAM_OR_DRAW.getId());
			}else{
				result.setSize(sizeCalculator.calculateForDoubleChance(result.getValue(), condition));
				result.setSelectionMarketBetId(SelectionMarketBetType.DRAW_OR_AWAY_TEAM.getId());
			}

			dc.setStats(result);
		
		} catch (ArithmeticException a) {
			
		}
	}

}
