package com.gamaset.sonicbot.collector.service.statistic.calculator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.detail.TeamMatchDetailDTO;
import com.gamaset.sonicbot.collector.dto.statistic.probability.FulltimeProbabilityDTO;
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
public class CalculatorFulltimeResultComponent {

	@Autowired
	private EffectSizeCalculatorComponent sizeCalculator;

	public List<FulltimeProbabilityDTO> calculate(List<TeamMatchDetailDTO> matchesByCondition, HomeAwayConditionEnum condition) {
		List<FulltimeProbabilityDTO> probs = new ArrayList<>();

		FulltimeProbabilityDTO ft = null;
		probs.add(ft = new FulltimeProbabilityDTO(CriteriaAnalisysMatchesTypeEnum.ALL_GAMES));
		calcProbs(matchesByCondition, condition, ft);
		probs.add(ft = new FulltimeProbabilityDTO(CriteriaAnalisysMatchesTypeEnum.LAST3_MATCHES));
		calcProbs(matchesByCondition, condition, ft);
		
		return probs;
	}

	private void calcProbs(List<TeamMatchDetailDTO> matches, HomeAwayConditionEnum condition,
			FulltimeProbabilityDTO ft) {
		StatsMarketDTO result = new StatsMarketDTO();

		int occurs = 0;

		int numberCriteriaMatches = ft.getNumberMatchesType()==CriteriaAnalisysMatchesTypeEnum.ALL_GAMES?matches.size():ft.getNumberMatchesType().getNumerOfMatches();
		int numberMatches = matches.size()>numberCriteriaMatches?numberCriteriaMatches:matches.size();
		for (int i = 0; i < numberMatches; i++) {	TeamMatchDetailDTO matchResume = matches.get(i);
			if (HomeAwayConditionEnum.HOME_TEAM.equals(condition)) {
				if (matchResume.getWinner() != null && matchResume.getWinner().equals(matchResume.getHomeTeamMatch())) {
					occurs++;
				}
			} else {
				if (matchResume.getWinner() != null && matchResume.getWinner().equals(matchResume.getAwayTeamMatch())) {
					occurs++;
				}
			}
		}

		result.setValue(occurs==0?0:new Double((occurs * 100) / numberMatches));
		if(HomeAwayConditionEnum.HOME_TEAM.equals(condition)){
			result.setSize(sizeCalculator.calculateForWin(result.getValue(), HomeAwayConditionEnum.HOME_TEAM));
			result.setSelectionMarketBetId(SelectionMarketBetTypeEnum.HOME_TEAM_WIN.getId());
		}else{
			result.setSize(sizeCalculator.calculateForWin(result.getValue(), HomeAwayConditionEnum.AWAY_TEAM));
			result.setSelectionMarketBetId(SelectionMarketBetTypeEnum.AWAY_TEAM_WIN.getId());
		}

		ft.setStats(result);
		
	}
	

}
