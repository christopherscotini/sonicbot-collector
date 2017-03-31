package com.gamaset.sonicbot.collector.service.match;

import org.springframework.stereotype.Component;

import com.gamaset.sonicbot.collector.dto.MatchResumeDTO;
import com.gamaset.sonicbot.collector.infra.exception.DataEntryInvalidException;

@Component
public class MatchDetailValidator {

	public void validate(MatchResumeDTO match) {

		if(match.getMatchId() == null || match.getMatchId() == 0){
			throw new DataEntryInvalidException("matchId");
		}
		
	}

}
