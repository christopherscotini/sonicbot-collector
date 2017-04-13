package com.gamaset.sonicbot.collector.service.academia.matchdetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.gamaset.sonicbot.collector.dto.MatchResumeDTO;
import com.gamaset.sonicbot.collector.dto.detail.MatchDetailDTO;
import com.gamaset.sonicbot.collector.infra.CachingConfig;
import com.gamaset.sonicbot.collector.service.academia.matchdetail.scrapper.MatchDetailAcademiaScrapperComponent;
import com.gamaset.sonicbot.collector.service.academia.matchdetail.validator.MatchDetailAcademiaValidator;

/**
 * 
 * @author Christopher Rozario
 *
 * @since 1.0.0
 */
@Service
public class MatchDetailAcademiaService {

	@Autowired
	private MatchDetailAcademiaScrapperComponent detailScrapperComponent;
	@Autowired
	private MatchDetailAcademiaValidator validator;

	/**
	 * 
	 * @param match
	 * @return a {@link MatchDetailDTO} object
	 */
	@Cacheable(cacheNames = CachingConfig.MATCH_DETAIL_CHACHE)
	public MatchDetailDTO detail(MatchResumeDTO match) {
		validator.validate(match);
		return detailScrapperComponent.scrap(match);
	}
	
}
