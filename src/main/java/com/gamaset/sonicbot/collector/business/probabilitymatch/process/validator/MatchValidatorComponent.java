package com.gamaset.sonicbot.collector.business.probabilitymatch.process.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.MatchDataDTO;
import com.gamaset.sonicbot.collector.dto.statistic.TeamStatisticsDTO;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@Component
public class MatchValidatorComponent {

	@Autowired
	private CompetitionSeasonValidatorComponent competitionSeasonValidatorComponent;

	/**
	 * 
	 * @param matchDataDTO
	 * @return
	 */
	public boolean validate(MatchDataDTO matchDataDTO) {
		if (!validateWithMatchesContainsAnalytics(matchDataDTO.getMatchstatistics().getHomeTeamStats())) {
			return false;
		}
		if (!validateWithMatchesContainsAnalytics(matchDataDTO.getMatchstatistics().getAwayTeamStats())) {
			return false;
		}

		// IGNORA CASO A COMPETICAO NAO ESTEJA CADASTRADA
		if (!competitionSeasonValidatorComponent.validate(matchDataDTO.getMatchResume().getCompetitionSeason())) {
			return false;
		}

		return true;
	}

	private boolean validateWithMatchesContainsAnalytics(TeamStatisticsDTO teamStats) {
		if (teamStats.getDoubleChanceProbabilities().isEmpty() || teamStats.getFulltimeProbabilities().isEmpty()
				|| teamStats.getGoalsProbabilities().isEmpty()) {
			return false;
		}
		return true;
	}

}
