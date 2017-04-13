package com.gamaset.sonicbot.collector.service.academia.match.validator;

import java.util.Objects;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.MatchResumeDTO;
import com.gamaset.sonicbot.collector.dto.MatchStatusEnum;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@Component
public class MatchAcademiaScrapperValidator {

	
	public boolean validate(MatchResumeDTO match, Set<Long> availableCompetitionsId) {

		Objects.requireNonNull(match.getMatchStatus(), "matchStatus cannot be null.");
		Objects.requireNonNull(availableCompetitionsId, "availableCompetitionsId cannot be null.");
		
		if (match.getMatchStatus() == MatchStatusEnum.ADIADO || match.getMatchStatus() == MatchStatusEnum.CANCELADO) {
			return false;
		}

		if (!availableCompetitionsId.contains(match.getCompetitionSeason().getCompetition().getId())) {
			return false;
		}

		return true;
	}

}
