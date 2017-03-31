package com.gamaset.sonicbot.collector.service.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamaset.sonicbot.collector.dto.MatchResumeDTO;
import com.gamaset.sonicbot.collector.service.match.scrapper.MatchDetailScrapperComponent;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@Service
public class MatchDetailService {

	@Autowired
	private MatchDetailScrapperComponent detailScrapperComponent;

	@Autowired
	private MatchDetailValidator validator;
	
	public void detail(MatchResumeDTO match) {

		validator.validate(match);
		
		detailScrapperComponent.scrap(match);
		
	}
	
}
