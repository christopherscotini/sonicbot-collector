package com.gamaset.sonicbot.collector.service.statistic.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.detail.TeamMatchDetailDTO;
import com.gamaset.sonicbot.collector.dto.statistic.probability.DoubleChanceProbabilityDTO;
import com.gamaset.sonicbot.collector.dto.statistic.probability.StatsMarketDTO;
import com.gamaset.sonicbot.collector.infra.constants.CriteriaAnalisysMatchesTypeEnum;
import com.gamaset.sonicbot.collector.infra.constants.HomeAwayConditionEnum;
import com.gamaset.sonicbot.collector.infra.constants.SelectionMarketBetTypeEnum;

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

	/**
	 * 
	 * @param matchesByCondition
	 * @param condition
	 * @return
	 */
	public List<DoubleChanceProbabilityDTO> calculate(List<TeamMatchDetailDTO> matchesByCondition, HomeAwayConditionEnum condition) {
		List<DoubleChanceProbabilityDTO> probs = new ArrayList<>();
		DoubleChanceProbabilityDTO dc = calcProbs(matchesByCondition, condition, CriteriaAnalisysMatchesTypeEnum.ALL_GAMES);
		DoubleChanceProbabilityDTO dc2 = calcProbs(matchesByCondition, condition, CriteriaAnalisysMatchesTypeEnum.LAST3_MATCHES);
		
		if(!Objects.isNull(dc)){
			probs.add(dc);
		}

		if(!Objects.isNull(dc2)){
			probs.add(dc2);
		}
		
		return probs;
	}

	private DoubleChanceProbabilityDTO calcProbs(List<TeamMatchDetailDTO> matches, HomeAwayConditionEnum condition,
			CriteriaAnalisysMatchesTypeEnum numberMatchesType) {
		
		int occurs = 0;

		int numberCriteriaMatches = numberMatchesType==CriteriaAnalisysMatchesTypeEnum.ALL_GAMES?matches.size():numberMatchesType.getNumerOfMatches();
		int numberMatches = matches.size()>numberCriteriaMatches?numberCriteriaMatches:matches.size();
		
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
			StatsMarketDTO result = new StatsMarketDTO();
			result.setValue(new Double((occurs * 100) / numberMatches));
			
			if(HomeAwayConditionEnum.HOME_TEAM.equals(condition)){
				result.setSize(sizeCalculator.calculateForDoubleChance(result.getValue(), condition));
				result.setSelectionMarketBetId(SelectionMarketBetTypeEnum.HOME_TEAM_OR_DRAW.getId());
			}else{
				result.setSize(sizeCalculator.calculateForDoubleChance(result.getValue(), condition));
				result.setSelectionMarketBetId(SelectionMarketBetTypeEnum.DRAW_OR_AWAY_TEAM.getId());
			}
			
			DoubleChanceProbabilityDTO ret = new DoubleChanceProbabilityDTO(numberMatchesType);
			ret.setStats(result);
			
			return ret;
		
		} catch (ArithmeticException a) {
			System.err.println(""+a.getMessage());
		}
		
		return null;
	}

}
